package com.ultronvision.bigcats.modules.cats.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ultronvision.bigcats.common.entity.cats.SysUser;
import com.ultronvision.bigcats.modules.cats.mapper.SysUserMapper;
import com.ultronvision.bigcats.modules.cats.service.ISysUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author oldwei
 * @date 2021/5/31 6:04 下午
 */
@Service
@RequiredArgsConstructor
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements ISysUserService {
}
