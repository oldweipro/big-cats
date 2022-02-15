package com.ultronvision.bigcats.common.oauth2;

import com.ultronvision.bigcats.modules.cats.entity.SysUser;
import com.ultronvision.bigcats.modules.cats.entity.SysUserToken;
import com.ultronvision.bigcats.modules.cats.service.IShiroService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.stereotype.Component;

import java.util.Set;

/**
 * 认证 用户登录鉴权和获取用户授权
 *
 * @author oldwei
 * @date 2021/5/31 2:17 下午
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class Oauth2Realm extends AuthorizingRealm {
    private final IShiroService shiroService;

    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof Oauth2Token;
    }

    /**
     * 授权（验证权限时调用）
     * 权限信息认证(包括角色以及权限)是用户访问controller的时候才进行验证(redis存储的此处权限信息)
     * 触发检测用户权限时才会调用此方法，例如checkRole,checkPermission
     *
     * @param principalCollection 身份信息
     * @return 权限信息
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        log.info("===============Shiro权限认证开始============ [ roles、permissions]==========");
        SysUser user = (SysUser) principalCollection.getPrimaryPrincipal();
        Long userId = user.getId();

        // 用户权限列表
        Set<String> userPermissions = this.shiroService.getUserPermissions(userId);
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.setStringPermissions(userPermissions);
        log.info("===============Shiro权限认证成功==============");
        return simpleAuthorizationInfo;
    }

    /**
     * 认证（登录时调用）
     * 用户信息认证是在用户进行登录的时候进行验证(不存redis)
     * 也就是说验证用户输入的账号和密码是否正确，错误抛出异常
     *
     * @param authenticationToken 用户登录的账号密码信息
     * @return 返回封装了用户信息的 AuthenticationInfo 实例
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        log.debug("===============Shiro身份认证开始============doGetAuthenticationInfo==========");
        String accessToken = (String) authenticationToken.getPrincipal();
        // 根据accessToken，查询用户信息
        SysUserToken sysUserTokenEntity = this.shiroService.queryByToken(accessToken);
        // accessToken失效
        if (null == sysUserTokenEntity || sysUserTokenEntity.getExpireTime().getTime() < System.currentTimeMillis()) {
            throw new IncorrectCredentialsException("token失效，请重新登录");
        }
        // 查询用户信息
        SysUser sysUserEntity = this.shiroService.queryUser(sysUserTokenEntity.getUserId());
        // 账号锁定
        if (0 == sysUserEntity.getStatus()) {
            throw new LockedAccountException("账号已被锁定,请联系管理员");
        }
        return new SimpleAuthenticationInfo(sysUserEntity, accessToken, getName());
    }
}
