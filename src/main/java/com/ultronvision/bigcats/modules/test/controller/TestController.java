package com.ultronvision.bigcats.modules.test.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author oldwei
 * @date 2021/5/31 12:41 下午
 */
@RestController
@RequestMapping("test")
public class TestController {
    @GetMapping("saySomething")
    public String saySomething(String message) {
        return message;
    }
}
