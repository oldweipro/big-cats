package com.ultronvision.bigcats.modules.cats.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ultronvision.bigcats.common.entity.cats.SysUserToken;

/**
 * @author oldwei
 * @date 2021/5/31 6:28 下午
 */
public interface ISysUserTokenService extends IService<SysUserToken> {

    /**
     * 生成token
     *
     * @param userId 用户ID
     * @return
     */
    String createToken(long userId);
    /**
     * 退出，修改token值
     *
     * @param userId 用户ID
     */
    void logout(long userId);
}
