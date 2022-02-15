package com.ultronvision.bigcats.modules.cats.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ultronvision.bigcats.modules.cats.entity.SysUser;

/**
 * @author oldwei
 * @date 2021/5/31 6:03 下午
 */
public interface ISysUserService extends IService<SysUser> {
    /**
     * 检查用户名重复
     *
     * @param username 用户名
     * @return true重复 false不重复
     */
    boolean checkUsernameDuplicate(String username);
}
