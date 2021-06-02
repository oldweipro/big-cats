package com.ultronvision.bigcats.modules.cats.controller;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SecureUtil;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.ultronvision.bigcats.common.entity.BaseController;
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
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 登录相关
 *
 * @author oldwei
 * @date 2021/5/31 5:32 下午
 */
@Slf4j
@RestController
@RequestMapping("auth")
@RequiredArgsConstructor
public class AuthController extends BaseController {
    private final ISysUserService sysUserService;
    private final ISysUserTokenService sysUserTokenService;

    /**
     * 用户注册
     *
     * @param user
     * @return
     */
    @PostMapping("register")
    public ResponseEntity<Boolean> registerWebsite(@RequestBody SysUser user) {
        LambdaQueryWrapper<SysUser> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(SysUser::getUsername, user.getUsername());
        SysUser one = this.sysUserService.getOne(lambdaQueryWrapper);
        if (one != null) {
            return ResponseEntity.ok(false);
        }
        List<SysUser> userList = new ArrayList<>();
        user.setPassword(SecureUtil.md5(user.getPassword()));
        userList.add(user);
        boolean b = this.sysUserService.saveBatch(userList);
        return ResponseEntity.ok(b);
    }

    /**
     * 用户登录
     *
     * @param user
     * @return
     */
    @PostMapping("login")
    public ResponseEntity<Map<String, Object>> login(@RequestBody SysUser user) {
        Map<String, Object> map = new HashMap<>(15);
        Map<String, Object> result = new HashMap<>(1);
        if (user.getUsername().isBlank()) {
            map.put("message", "登录失败");
            result.put("result", map);
            return ResponseEntity.ok(result);
        }
        LambdaQueryWrapper<SysUser> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(SysUser::getUsername, user.getUsername());
        SysUser one = this.sysUserService.getOne(lambdaQueryWrapper);
        if (one == null) {
            map.put("message", "登录失败");
            result.put("result", map);
            return ResponseEntity.ok(result);
        }
        boolean equals = StrUtil.equals(one.getPassword(), user.getPassword());
        if (!equals) {
            map.put("message", "登录失败");
            result.put("result", map);
            return ResponseEntity.ok(result);
        }
        String token = this.sysUserTokenService.createToken(one.getId());

        map.put("id", RandomUtil.randomString(20));
        map.put("name", "oldwei");
        map.put("username", "admin");
        map.put("password", "");
        map.put("avatar", "https://gw.alipayobjects.com/zos/rmsportal/jZUIxmJycoymBprLOUbT.png");
        map.put("status", 1);
        map.put("telephone", "");
        map.put("lastLoginIp", "27.154.74.117");
        map.put("lastLoginTime", "1534837621348");
        map.put("creatorId", "admin");
        map.put("createTime", "1497160610259");
        map.put("deleted", 0);
        map.put("roleId", "admin");
        map.put("lang", "zh-CN");
        map.put("token", token);
        result.put("result", map);
        return ResponseEntity.ok(result);
    }

    /**
     * 退出登录
     *
     * @return
     */
    @PostMapping("logout")
    public ResponseEntity<Map<String, Object>> logout() {
        Map<String, Object> map = new HashMap<>(1);
        this.sysUserTokenService.logout(getUserId());
        map.put("message", "注销成功");
        return ResponseEntity.ok(map);
    }

    /**
     * 发送验证码
     *
     * @return
     */
    @PostMapping("account/sms")
    public ResponseEntity<Map<String, Object>> smsCaptcha() {
        Map<String, Object> result = new HashMap<>(1);
        Map<String, Object> map = new HashMap<>(1);
        map.put("captcha", RandomUtil.randomInt(100000, 999999));
        result.put("result", map);
        return ResponseEntity.ok(result);
    }

    /**
     * 双因素认证
     *
     * @return
     */
    @PostMapping("2step-code")
    public ResponseEntity<Map<String, Object>> twoFactor() {
        Map<String, Object> result = new HashMap<>(1);
        Map<String, Object> map = new HashMap<>(1);
        map.put("stepCode", RandomUtil.randomInt(0, 1));
        result.put("result", map);
        return ResponseEntity.ok(result);
    }

    /**
     * 忘记密码
     *
     * @return
     */
    @PostMapping("forget-password")
    public ResponseEntity<Map<String, Object>> forgetPassword() {
        Map<String, Object> result = new HashMap<>(1);
        result.put("result", "map");
        return ResponseEntity.ok(result);
    }
}
