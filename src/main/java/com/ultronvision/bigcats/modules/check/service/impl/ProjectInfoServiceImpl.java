package com.ultronvision.bigcats.modules.check.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ultronvision.bigcats.modules.check.entity.po.ProjectInfoPO;
import com.ultronvision.bigcats.modules.check.mapper.ProjectInfoMapper;
import com.ultronvision.bigcats.modules.check.service.IProjectInfoService;
import org.springframework.stereotype.Service;

/**
 * @author oldwei
 * @date 2021-12-15 15:30
 */
@Service
public class ProjectInfoServiceImpl extends ServiceImpl<ProjectInfoMapper, ProjectInfoPO> implements IProjectInfoService {
}
