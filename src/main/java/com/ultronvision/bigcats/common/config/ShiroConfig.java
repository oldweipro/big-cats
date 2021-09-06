package com.ultronvision.bigcats.common.config;

import com.ultronvision.bigcats.common.oauth2.Oauth2Filter;
import com.ultronvision.bigcats.common.oauth2.Oauth2Realm;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.Filter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * Shiro 配置类
 *
 * @author oldwei
 * @date 2021/5/31 12:53 下午
 */
@Configuration
public class ShiroConfig {

    /**
     * 权限管理，配置主要是Realm的管理认证
     *
     * @param oauth2Realm
     * @return
     */
    @Bean("securityManager")
    public SecurityManager securityManager(Oauth2Realm oauth2Realm) {
        DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();
        //将自己的验证方式加入容器
        defaultWebSecurityManager.setRealm(oauth2Realm);
        defaultWebSecurityManager.setRememberMeManager(null);
        return defaultWebSecurityManager;
    }

    @Bean("shiroFilter")
    public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        //oauth过滤
        Map<String, Filter> filters = new HashMap<>(1);
        filters.put("oauth2", new Oauth2Filter());
        shiroFilterFactoryBean.setFilters(filters);
        Map<String, String> filterMap = new LinkedHashMap<>();
        filterMap.put("/auth/register", "anon");
        filterMap.put("/auth/login", "anon");
        filterMap.put("/auth/account/sms", "anon");
        filterMap.put("/auth/2step-code", "anon");
        filterMap.put("/hik/**", "anon");
        filterMap.put("/swagger*/**", "anon");
        filterMap.put("/v2/**", "anon");
        filterMap.put("/doc.html", "anon");
        filterMap.put("/webjars/**", "anon");
        filterMap.put("/**", "oauth2");
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterMap);
        return shiroFilterFactoryBean;
    }

    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor advisor = new AuthorizationAttributeSourceAdvisor();
        advisor.setSecurityManager(securityManager);
        return advisor;
    }
}
