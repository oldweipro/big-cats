package com.ultronvision.bigcats.modules.cats.controller;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.json.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.ultronvision.bigcats.common.entity.BaseController;
import com.ultronvision.bigcats.common.entity.cats.SysUser;
import com.ultronvision.bigcats.modules.cats.service.ISysUserService;
import com.ultronvision.bigcats.modules.cats.service.ISysUserTokenService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

/**
 * 登录相关
 *
 * @author oldwei
 * @date 2021/5/31 5:32 下午
 */
@Api("登录相关")
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
    @ApiOperation("用户注册")
    public ResponseEntity<JSONObject> registerWebsite(@RequestBody SysUser user) {
        LambdaQueryWrapper<SysUser> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(StrUtil.isNotBlank(user.getUsername()), SysUser::getUsername, user.getUsername());
        SysUser one = this.sysUserService.getOne(lambdaQueryWrapper);
        JSONObject result = new JSONObject();
        if (one != null) {
            result.set("result", one.getUsername());
            result.set("msg", "注册失败，用户名已存在。");
            return ResponseEntity.badRequest().body(result);
        }
        lambdaQueryWrapper.or().eq(StrUtil.isNotBlank(user.getEmail()), SysUser::getEmail, user.getEmail());
        SysUser one2 = this.sysUserService.getOne(lambdaQueryWrapper);
        if (one2 != null) {
            result.set("result", one2.getEmail());
            result.set("msg", "注册失败，邮箱已存在。");
            return ResponseEntity.badRequest().body(result);
        }
        List<SysUser> userList = new ArrayList<>();
        userList.add(user);
        boolean b = this.sysUserService.saveBatch(userList);
        result.set("result", b);
        result.set("msg", "注册成功。");
        return ResponseEntity.ok(result);
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
            return ResponseEntity.badRequest().body(result);
        }
        LambdaQueryWrapper<SysUser> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(SysUser::getUsername, user.getUsername());
        SysUser one = this.sysUserService.getOne(lambdaQueryWrapper);
        if (one == null) {
            map.put("message", "登录失败");
            result.put("result", map);
            return ResponseEntity.badRequest().body(result);
        }
        boolean equals = StrUtil.equals(one.getPassword(), user.getPassword());
        if (!equals) {
            map.put("message", "登录失败");
            result.put("result", map);
            return ResponseEntity.badRequest().body(result);
        }
        String token = this.sysUserTokenService.createToken(one.getId());

        map.put("token", token);
        map.put("tenantId", one.getTenantId());
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
