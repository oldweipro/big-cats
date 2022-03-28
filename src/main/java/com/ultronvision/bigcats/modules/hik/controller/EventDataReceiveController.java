package com.ultronvision.bigcats.modules.hik.controller;

import com.alibaba.fastjson.JSONObject;
import com.ultronvision.bigcats.common.entity.BaseController;
import com.ultronvision.bigcats.common.entity.hik.ProbeMatch;
import com.ultronvision.bigcats.modules.hik.service.IProbeMatchService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 事件数据接收接口
 *
 * @author oldwei
 * @date 2021-9-16 15:00
 */
@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("hik/api")
public class EventDataReceiveController extends BaseController {
    private final IProbeMatchService probeMatchService;

    /**
     * 设备搜索
     *
     * @param json
     */
    @PostMapping("deviceSearch")
    public void deviceSearch(@RequestBody JSONObject json) {
        ProbeMatch probeMatch = json.toJavaObject(ProbeMatch.class);
        this.probeMatchService.saveOrUpdate(probeMatch);
    }

    /**
     * 门禁事件
     *
     * @param json
     */
    @PostMapping("accessControlEvent")
    public void accessControlEvent(@RequestBody JSONObject json) {
        log.info("门禁事件:{}", json);
    }

    /**
     * 人脸抓拍事件
     *
     * @param json
     */
    @PostMapping("faceCaptureEvent")
    public void faceCaptureEvent(@RequestBody JSONObject json) {
        log.info("人脸抓拍事件:{}", json);
    }
}
