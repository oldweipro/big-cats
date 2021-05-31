package com.ultronvision.bigcats.common.entity.oauth2;

import org.apache.shiro.authc.AuthenticationToken;

/**
 * token
 *
 * @author oldwei
 * @date 2021/5/31 2:22 下午
 */
public class Oauth2Token implements AuthenticationToken {
    private static final long serialVersionUID = -6123101144512477249L;
    private final String token;

    public Oauth2Token(String token) {
        this.token = token;
    }

    @Override
    public String getPrincipal() {
        return this.token;
    }

    @Override
    public Object getCredentials() {
        return this.token;
    }
}
