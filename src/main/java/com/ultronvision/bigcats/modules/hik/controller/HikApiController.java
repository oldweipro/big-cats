package com.ultronvision.bigcats.modules.hik.controller;

import cn.hutool.core.util.StrUtil;
import com.ultronvision.bigcats.common.constant.ParamsConstant;
import com.ultronvision.bigcats.common.entity.BaseController;
import com.ultronvision.bigcats.common.entity.hik.Device;
import com.ultronvision.bigcats.common.util.BigCatsUtil;
import com.ultronvision.bigcats.modules.hik.service.IDeviceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author oldwei
 * @date 2021-8-5 12:41
 */
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("hik/api")
public class HikApiController extends BaseController {
    private final IDeviceService deviceService;


    @PostMapping("deviceLogin")
    public ResponseEntity<String> deviceLogin(@RequestBody Device device) {
        Device getById = this.deviceService.getById(device.getId());
        String body = BigCatsUtil.httpPost(ParamsConstant.URL + "api/device/deviceLogin", getById);
        return ResponseEntity.ok(body);
    }

    @PostMapping("deviceClean")
    public ResponseEntity<String> deviceClean(@RequestBody Device device) {
        String body = BigCatsUtil.httpPost(ParamsConstant.URL + "api/device/deviceClean", device);
        return ResponseEntity.ok(body);
    }

    @PostMapping("deviceSetupAlarm")
    public ResponseEntity<String> deviceSetupAlarm(@RequestBody Device device) {
        String body = BigCatsUtil.httpPost(ParamsConstant.URL + "api/device/setupAlarm", device);
        return ResponseEntity.ok(body);
    }

    @PostMapping("deviceCloseAlarm")
    public ResponseEntity<String> deviceCloseAlarm(@RequestBody Device device) {
        String body = BigCatsUtil.httpPost(ParamsConstant.URL + "api/device/closeAlarm", device);
        return ResponseEntity.ok(body);
    }

    @PostMapping("deviceStartPushStream")
    public ResponseEntity<String> deviceStartPushStream(@RequestBody Device device) {
//        String body = BigCatsUtil.httpPost(ParamsConstant.URL + "api/device/startPushStream/" + device.getIp(), null);
        Device byId = this.deviceService.getById(device.getId());
        String rtsp = "rtsp://" + byId.getUsername() +":" + byId.getPassword() + "@"+ byId.getIp() +":554/h264/ch1/sub/av_stream";
        byId.setRtspUrl(rtsp);
        String body = BigCatsUtil.httpPost(ParamsConstant.URL + "api/device/startRtspPushStream", byId);
        return ResponseEntity.ok(body);
    }

    @PostMapping("deviceExistPushStream")
    public ResponseEntity<String> deviceExistPushStream(@RequestBody Device device) {
        String body = BigCatsUtil.httpPost(ParamsConstant.URL + "api/device/existPushStream", device);
        return ResponseEntity.ok(body);
    }

    @PostMapping("deviceStreamList")
    public ResponseEntity<String> devicePullStream(@RequestBody Device device) {
        String body;
        if (StrUtil.isNotBlank(device.getIp())) {
            body = BigCatsUtil.httpGet(ParamsConstant.URL + "api/device/streamList/" + device.getIp());
        } else {
            body = BigCatsUtil.httpGet(ParamsConstant.URL + "api/device/streamList");
        }
        return ResponseEntity.ok(body);
    }
}
