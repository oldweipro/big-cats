package com.ultronvision.bigcats.modules.check.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ultronvision.bigcats.modules.check.entity.po.UserProjectPermissionPO;
import com.ultronvision.bigcats.modules.check.mapper.UserProjectPermissionMapper;
import com.ultronvision.bigcats.modules.check.service.IUserProjectPermissionService;
import org.springframework.stereotype.Service;

/**
 * @author oldwei
 * @date 2021-12-15 15:33
 */
@Service
public class UserProjectPermissionServiceImpl extends ServiceImpl<UserProjectPermissionMapper, UserProjectPermissionPO> implements IUserProjectPermissionService {
}
