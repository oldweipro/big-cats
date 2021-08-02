package com.ultronvision.bigcats.modules.hik.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ultronvision.bigcats.common.entity.hik.Device;
import com.ultronvision.bigcats.modules.hik.mapper.DeviceMapper;
import com.ultronvision.bigcats.modules.hik.service.IDeviceService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author oldwei
 * @date 2021-8-2 09:59
 */
@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class DeviceServiceImpl extends ServiceImpl<DeviceMapper, Device> implements IDeviceService {
}