package com.ultronvision.bigcats.modules.cats.service.impl;

import cn.hutool.core.util.StrUtil;
import com.ultronvision.bigcats.modules.cats.entity.SysMenu;
import com.ultronvision.bigcats.modules.cats.entity.SysUser;
import com.ultronvision.bigcats.modules.cats.entity.SysUserToken;
import com.ultronvision.bigcats.modules.cats.mapper.SysUserMapper;
import com.ultronvision.bigcats.modules.cats.mapper.SysUserTokenMapper;
import com.ultronvision.bigcats.modules.cats.mapper.SysMenuMapper;
import com.ultronvision.bigcats.modules.cats.service.IShiroService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;

/**
 * @author oldwei
 * @date 2021/5/31 3:09 下午
 */
@Service
@RequiredArgsConstructor
public class ShiroServiceImpl implements IShiroService {
    private final SysMenuMapper sysMenuMapper;
    private final SysUserMapper sysUserMapper;
    private final SysUserTokenMapper sysUserTokenMapper;
    @Override
    public Set<String> getUserPermissions(long userId) {
        List<String> permissionsList;
        // 系统管理员拥有最高权限
        if (userId == 1) {
            List<SysMenu> menuEntityList = this.sysMenuMapper.selectList(null);
            permissionsList = new ArrayList<>(menuEntityList.size());
            for (SysMenu sysMenu :
                    menuEntityList) {
                permissionsList.add(sysMenu.getPerms());
            }
        } else {
            permissionsList = this.sysUserMapper.queryAllPerms(userId);
        }
        // 用户权限列表
        Set<String> userPermissions = new HashSet<>();
        for (String permissions :
                permissionsList) {
            if (StrUtil.isBlank(permissions)) {
                continue;
            }
            userPermissions.addAll(Arrays.asList(permissions.trim().split(",")));
        }
        return userPermissions;
    }

    @Override
    public SysUserToken queryByToken(String token) {
        return this.sysUserTokenMapper.queryByToken(token);
    }

    @Override
    public SysUser queryUser(Long userId) {
        return this.sysUserMapper.selectById(userId);
    }
}
