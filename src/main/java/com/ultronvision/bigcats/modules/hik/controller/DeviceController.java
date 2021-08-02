package com.ultronvision.bigcats.modules.hik.controller;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.json.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.ultronvision.bigcats.common.entity.BaseController;
import com.ultronvision.bigcats.common.entity.hik.Device;
import com.ultronvision.bigcats.modules.hik.service.IDeviceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

/**
 * @author oldwei
 * @date 2021-8-2 09:58
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("device")
public class DeviceController extends BaseController {

    private final IDeviceService deviceService;

    /**
     * 分页列表
     * @return
     */
    @GetMapping
    public ResponseEntity<JSONObject> device(@RequestBody Device device) {
        LambdaQueryWrapper<Device> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(ObjectUtil.isNotNull(device.getCategoryId()), Device::getCategoryId, device.getCategoryId());
        List<Device> list = this.deviceService.list(lambdaQueryWrapper);
        JSONObject result = new JSONObject();
        result.set("result", list);
        return ResponseEntity.ok(result);
    }

    @PostMapping
    public ResponseEntity<JSONObject> addDevice(@RequestBody Device device) {
        boolean save = this.deviceService.save(device);
        JSONObject result = new JSONObject();
        result.set("result", save);
        return ResponseEntity.ok(result);
    }

    @PutMapping
    public ResponseEntity<JSONObject> modifyDevice(@RequestBody Device device) {
        boolean updateById = this.deviceService.updateById(device);
        JSONObject result = new JSONObject();
        result.set("result", updateById);
        return ResponseEntity.ok(result);
    }

    @DeleteMapping("/{deviceIds}")
    public ResponseEntity<JSONObject> deleteDevice(@PathVariable String deviceIds) {
        // 构造条件
        String[] ids = deviceIds.split(StringPool.COMMA);
        List<String> list = Arrays.asList(ids);
        boolean removeByIds = this.deviceService.removeByIds(list);
        JSONObject result = new JSONObject();
        result.set("result", removeByIds);
        return ResponseEntity.ok(result);
    }
}
