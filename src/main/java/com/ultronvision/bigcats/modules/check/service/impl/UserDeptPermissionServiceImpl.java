package com.ultronvision.bigcats.modules.check.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ultronvision.bigcats.modules.check.entity.po.UserDeptPermissionPO;
import com.ultronvision.bigcats.modules.check.mapper.UserDeptPermissionMapper;
import com.ultronvision.bigcats.modules.check.service.IUserDeptPermissionService;
import org.springframework.stereotype.Service;

/**
 * @author oldwei
 * @date 2021-12-15 15:31
 */
@Service
public class UserDeptPermissionServiceImpl extends ServiceImpl<UserDeptPermissionMapper, UserDeptPermissionPO> implements IUserDeptPermissionService {
}
