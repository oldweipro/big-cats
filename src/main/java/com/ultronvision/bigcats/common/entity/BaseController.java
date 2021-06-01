package com.ultronvision.bigcats.common.entity;

import com.ultronvision.bigcats.common.entity.cats.SysUser;
import org.apache.shiro.SecurityUtils;

/**
 * @author oldwei
 * @date 2021/6/1 4:08 下午
 */
public abstract class BaseController {
    protected SysUser getUser() {
        return (SysUser) SecurityUtils.getSubject().getPrincipal();
    }

    protected Long getUserId() {
        return getUser().getId();
    }
}
