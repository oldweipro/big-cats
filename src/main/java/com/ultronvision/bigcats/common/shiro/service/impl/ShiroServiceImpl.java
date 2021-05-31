package com.ultronvision.bigcats.common.shiro.service.impl;

import com.ultronvision.bigcats.common.entity.SysUser;
import com.ultronvision.bigcats.common.entity.SysUserToken;
import com.ultronvision.bigcats.common.shiro.service.IShiroService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Set;

/**
 * @author oldwei
 * @date 2021/5/31 3:09 下午
 */
@Service
@RequiredArgsConstructor
public class ShiroServiceImpl implements IShiroService {
    @Override
    public Set<String> getUserPermissions(long userId) {
        return null;
    }

    @Override
    public SysUserToken queryByToken(String token) {
        return null;
    }

    @Override
    public SysUser queryUser(Long userId) {
        return null;
    }
}
