package com.ultronvision.bigcats.modules.check.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ultronvision.bigcats.modules.check.entity.po.CompanyInfoPO;
import com.ultronvision.bigcats.modules.check.mapper.CompanyInfoMapper;
import com.ultronvision.bigcats.modules.check.service.ICompanyInfoService;
import org.springframework.stereotype.Service;

/**
 * @author oldwei
 * @date 2021-12-15 15:29
 */
@Service
public class CompanyInfoServiceImpl extends ServiceImpl<CompanyInfoMapper, CompanyInfoPO> implements ICompanyInfoService {
}
