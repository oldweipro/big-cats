package com.ultronvision.bigcats.modules.hik.controller;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ultronvision.bigcats.common.constant.ParamsConstant;
import com.ultronvision.bigcats.common.entity.BaseController;
import com.ultronvision.bigcats.common.entity.QueryRequest;
import com.ultronvision.bigcats.common.entity.hik.Device;
import com.ultronvision.bigcats.common.entity.hik.ProbeMatch;
import com.ultronvision.bigcats.common.util.BigCatsUtil;
import com.ultronvision.bigcats.modules.hik.service.IDeviceService;
import com.ultronvision.bigcats.modules.hik.service.IProbeMatchService;
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
    private final IProbeMatchService probeMatchService;

    @GetMapping("search")
    public ResponseEntity<JSONObject> deviceSearch(QueryRequest queryRequest) {
        LambdaQueryWrapper<ProbeMatch> queryWrapper = new LambdaQueryWrapper<>();
        Page<ProbeMatch> page = this.probeMatchService.page(new Page<>(queryRequest.getPageNo(), queryRequest.getPageSize()), queryWrapper);
        Map<String, Object> dataTable = BigCatsUtil.getDataTable(page);
        JSONObject result = new JSONObject();
        result.put("result", dataTable);
        return ResponseEntity.ok(result);
    }

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
            String loginStatus = BigCatsUtil.httpGet(ParamsConstant.URL + "api/device/deviceLoginStatus?deviceSn=" + deviceObj.getDeviceSn());
            deviceObj.setLoginStatus(loginStatus);
            String pushStatus = BigCatsUtil.httpGet(ParamsConstant.URL + "api/device/devicePushStatus?deviceSn=" + deviceObj.getDeviceSn());
            deviceObj.setPushStatus(pushStatus);
            String alarmStatus = BigCatsUtil.httpGet(ParamsConstant.URL + "api/device/deviceAlarmStatus?deviceSn=" + deviceObj.getDeviceSn());
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

    /**
     * 添加设备
     *
     * @param device
     * @return
     */
    @PostMapping
    public ResponseEntity<JSONObject> addDevice(@RequestBody Device device) {
        String post = HttpUtil.post(ParamsConstant.URL + "api/device/deviceLogin", JSONObject.toJSONString(device));
        if (StrUtil.equals("true", post)) {
            this.deviceService.save(device);
        }
        JSONObject result = new JSONObject();
        result.put("result", post);
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
