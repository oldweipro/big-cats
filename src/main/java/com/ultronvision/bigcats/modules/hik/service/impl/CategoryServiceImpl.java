package com.ultronvision.bigcats.modules.hik.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ultronvision.bigcats.common.entity.hik.Category;
import com.ultronvision.bigcats.modules.hik.mapper.CategoryMapper;
import com.ultronvision.bigcats.modules.hik.service.ICategoryService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author oldwei
 * @date 2021-8-2 11:15
 */
@Slf4j
@Service
@DS("hik")
@RequiredArgsConstructor
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements ICategoryService {
}
