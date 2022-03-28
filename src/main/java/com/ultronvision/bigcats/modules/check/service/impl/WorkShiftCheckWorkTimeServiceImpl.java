package com.ultronvision.bigcats.modules.check.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ultronvision.bigcats.modules.check.entity.po.WorkShiftCheckWorkTimePO;
import com.ultronvision.bigcats.modules.check.mapper.WorkShiftCheckWorkTimeMapper;
import com.ultronvision.bigcats.modules.check.service.IWorkShiftCheckWorkTimeService;
import org.springframework.stereotype.Service;

/**
 * @author oldwei
 * @date 2021-12-15 15:34
 */
@Service
public class WorkShiftCheckWorkTimeServiceImpl extends ServiceImpl<WorkShiftCheckWorkTimeMapper, WorkShiftCheckWorkTimePO> implements IWorkShiftCheckWorkTimeService {
}
