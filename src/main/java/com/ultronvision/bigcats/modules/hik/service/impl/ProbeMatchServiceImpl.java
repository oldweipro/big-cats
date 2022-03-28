package com.ultronvision.bigcats.modules.hik.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ultronvision.bigcats.common.entity.hik.ProbeMatch;
import com.ultronvision.bigcats.modules.hik.mapper.ProbeMatchMapper;
import com.ultronvision.bigcats.modules.hik.service.IProbeMatchService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author oldwei
 * @date 2021-9-16 15:44
 */
@Slf4j
@Service
@DS("hik")
@RequiredArgsConstructor
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class ProbeMatchServiceImpl extends ServiceImpl<ProbeMatchMapper, ProbeMatch> implements IProbeMatchService {
}
