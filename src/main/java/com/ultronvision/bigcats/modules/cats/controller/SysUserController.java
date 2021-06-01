package com.ultronvision.bigcats.modules.cats.controller;

import com.ultronvision.bigcats.common.entity.BaseController;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户相关
 *
 * @author oldwei
 * @date 2021/6/1 4:52 下午
 */
@Slf4j
@RestController
@RequestMapping("user")
@RequiredArgsConstructor
public class SysUserController extends BaseController {
    @GetMapping("info")
    public String info() {
        return "";
    }
}
