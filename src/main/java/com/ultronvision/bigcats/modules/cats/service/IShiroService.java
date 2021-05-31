package com.ultronvision.bigcats.modules.cats.service;

import com.ultronvision.bigcats.common.entity.cats.SysUser;
import com.ultronvision.bigcats.common.entity.cats.SysUserToken;

import java.util.Set;

/**
 * Shiro相关接口
 *
 * @author oldwei
 * @date 2021/5/31 2:21 下午
 */
public interface IShiroService {
    /**
     * 获取用户权限列表
     *
     * @param userId 用户ID
     * @return
     */
    Set<String> getUserPermissions(long userId);

    /**
     * 根据accessToken，查询用户信息
     *
     * @param token
     * @return
     */
    SysUserToken queryByToken(String token);

    /**
     * 根据用户ID，查询用户
     *
     * @param userId
     * @return
     */
    SysUser queryUser(Long userId);
}
