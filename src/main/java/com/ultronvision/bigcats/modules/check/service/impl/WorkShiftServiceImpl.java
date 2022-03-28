package com.ultronvision.bigcats.modules.check.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ultronvision.bigcats.modules.check.entity.po.WorkShiftPO;
import com.ultronvision.bigcats.modules.check.mapper.WorkShiftMapper;
import com.ultronvision.bigcats.modules.check.service.IWorkShiftService;
import org.springframework.stereotype.Service;

/**
 * @author oldwei
 * @date 2021-12-15 15:35
 */
@Service
public class WorkShiftServiceImpl extends ServiceImpl<WorkShiftMapper, WorkShiftPO> implements IWorkShiftService {
}
