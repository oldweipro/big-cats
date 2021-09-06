package com.ultronvision.bigcats.modules.hik.controller;

import cn.hutool.core.util.ObjectUtil;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ultronvision.bigcats.common.constant.ParamsConstant;
import com.ultronvision.bigcats.common.entity.BaseController;
import com.ultronvision.bigcats.common.entity.hik.Device;
import com.ultronvision.bigcats.common.util.BigCatsUtil;
import com.ultronvision.bigcats.modules.hik.service.IDeviceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @author oldwei
 * @date 2021-8-2 09:58
 */
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("hik/device")
public class DeviceController extends BaseController {

    private final IDeviceService deviceService;

    /**
     * 分页列表
     *
     * @return
     */
    @GetMapping
    public ResponseEntity<JSONObject> device(Device device) {
        LambdaQueryWrapper<Device> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(ObjectUtil.isNotNull(device.getCategoryId()), Device::getCategoryId, device.getCategoryId());
        IPage<Device> page = new Page<>(device.getPageNo(), device.getPageSize());
        IPage<Device> deviceIPage = this.deviceService.page(page, lambdaQueryWrapper);
        deviceIPage.getRecords().forEach(deviceObj -> {
            String loginStatus = BigCatsUtil.httpGet(ParamsConstant.URL + "api/device/deviceLoginStatus?ip=" + deviceObj.getIp());
            deviceObj.setLoginStatus(loginStatus);
            String pushStatus = BigCatsUtil.httpGet(ParamsConstant.URL + "api/device/devicePushStatus?ip=" + deviceObj.getIp());
            deviceObj.setPushStatus(pushStatus);
            String alarmStatus = BigCatsUtil.httpGet(ParamsConstant.URL + "api/device/deviceAlarmStatus?ip=" + deviceObj.getIp());
            deviceObj.setAlarmStatus(alarmStatus);
        });
        Map<String, Object> dataTable = BigCatsUtil.getDataTable(deviceIPage);
        JSONObject result = new JSONObject();
        result.put("result", dataTable);
        return ResponseEntity.ok(result);
    }

    @GetMapping("getStreamListByCategoryId")
    public ResponseEntity<JSONObject> getStreamListByCategoryId(Long categoryId, Integer pageNo, Integer pageSize) {
        LambdaQueryWrapper<Device> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(Device::getCategoryId, categoryId);
        IPage<Device> page = new Page<>(pageNo, pageSize);
        IPage<Device> deviceIPage = this.deviceService.page(page, lambdaQueryWrapper);
        Map<String, Object> dataTable = BigCatsUtil.getDataTable(deviceIPage);
        JSONObject result = new JSONObject();
        result.put("result", dataTable);
        return ResponseEntity.ok(result);
    }

    @PostMapping
    public ResponseEntity<JSONObject> addDevice(@RequestBody Device device) {
        boolean save = this.deviceService.save(device);
        JSONObject result = new JSONObject();
        result.put("result", save);
        return ResponseEntity.ok(result);
    }

    @PutMapping
    public ResponseEntity<JSONObject> modifyDevice(@RequestBody Device device) {
        boolean updateById = this.deviceService.updateById(device);
        JSONObject result = new JSONObject();
        result.put("result", updateById);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/{deviceIds}")
    public ResponseEntity<JSONObject> deleteDevice(@PathVariable String deviceIds) {
        // 构造条件
        String[] ids = deviceIds.split(StringPool.COMMA);
        List<String> list = Arrays.asList(ids);
        boolean removeByIds = this.deviceService.removeByIds(list);
        JSONObject result = new JSONObject();
        result.put("result", removeByIds);
        return ResponseEntity.ok(result);
    }
}
