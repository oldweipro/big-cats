package com.ultronvision.bigcats.modules.check.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ultronvision.bigcats.modules.check.entity.po.WorkShiftUserPO;
import com.ultronvision.bigcats.modules.check.mapper.WorkShiftUserMapper;
import com.ultronvision.bigcats.modules.check.service.IWorkShiftUserService;
import org.springframework.stereotype.Service;

/**
 * @author oldwei
 * @date 2021-12-15 15:36
 */
@Service
public class WorkShiftUserServiceImpl extends ServiceImpl<WorkShiftUserMapper, WorkShiftUserPO> implements IWorkShiftUserService {
}
