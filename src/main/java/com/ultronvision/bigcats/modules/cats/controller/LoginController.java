package com.ultronvision.bigcats.modules.cats.controller;

import cn.hutool.core.util.StrUtil;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.ultronvision.bigcats.common.entity.cats.SysUser;
import com.ultronvision.bigcats.modules.cats.service.ISysUserService;
import com.ultronvision.bigcats.modules.cats.service.ISysUserTokenService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * 登录相关
 *
 * @author oldwei
 * @date 2021/5/31 5:32 下午
 */
@Slf4j
@RestController
@RequestMapping("cats")
@RequiredArgsConstructor
public class LoginController {
    private final ISysUserService sysUserService;
    private final ISysUserTokenService sysUserTokenService;

    @PostMapping("register")
    public ResponseEntity<Boolean> registerWebsite(@RequestBody SysUser user) {
        LambdaQueryWrapper<SysUser> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(SysUser::getUsername, user.getUsername());
        SysUser one = this.sysUserService.getOne(lambdaQueryWrapper);
        if (one != null) {
            return ResponseEntity.ok(false);
        }
        List<SysUser> userList = new ArrayList<>();
        userList.add(user);
        boolean b = this.sysUserService.saveBatch(userList);
        return ResponseEntity.ok(b);
    }

    @PostMapping("login")
    public ResponseEntity<String> login(@RequestBody SysUser user) {
        if (user.getUsername().isBlank()) {
            return ResponseEntity.ok("登录失败");
        }
        LambdaQueryWrapper<SysUser> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(SysUser::getUsername, user.getUsername());
        SysUser one = this.sysUserService.getOne(lambdaQueryWrapper);
        if (one == null) {
            return ResponseEntity.ok("登录失败");
        }
        boolean equals = StrUtil.equals(one.getPassword(), user.getPassword());
        if (!equals) {
            return ResponseEntity.ok("登录失败");
        }
        String token = this.sysUserTokenService.createToken(one.getId());
        return ResponseEntity.ok("登录成功:" + token);
    }
}
