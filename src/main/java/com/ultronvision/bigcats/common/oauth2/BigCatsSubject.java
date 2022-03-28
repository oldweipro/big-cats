package com.ultronvision.bigcats.common.oauth2;

import com.ultronvision.bigcats.modules.cats.entity.pojo.SysUser;
import org.apache.shiro.SecurityUtils;

/**
 * @author oldwei
 * @date 2021-6-8 16:30
 */
public class BigCatsSubject {
    public static SysUser getUser() {
        return (SysUser) SecurityUtils.getSubject().getPrincipal();
    }

    public static Long getUserId() {
        return BigCatsSubject.getUser().getId();
    }
}
