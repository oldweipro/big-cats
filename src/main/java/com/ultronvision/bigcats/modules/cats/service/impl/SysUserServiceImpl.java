package com.ultronvision.bigcats.modules.cats.service.impl;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ultronvision.bigcats.modules.cats.entity.SysUser;
import com.ultronvision.bigcats.modules.cats.mapper.SysUserMapper;
import com.ultronvision.bigcats.modules.cats.service.ISysUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author oldwei
 * @date 2021/5/31 6:04 下午
 */
@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements ISysUserService {
    @Override
    public boolean checkUsernameDuplicate(String username) {
        LambdaQueryWrapper<SysUser> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(SysUser::getUsername, username);
        SysUser sysUser = this.baseMapper.selectOne(lambdaQueryWrapper);
        return ObjectUtil.isNotNull(sysUser);
    }
}
