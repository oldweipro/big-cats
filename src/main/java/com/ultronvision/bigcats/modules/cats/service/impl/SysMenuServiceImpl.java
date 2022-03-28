package com.ultronvision.bigcats.modules.cats.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ultronvision.bigcats.modules.cats.entity.pojo.SysMenu;
import com.ultronvision.bigcats.modules.cats.mapper.SysMenuMapper;
import com.ultronvision.bigcats.modules.cats.service.ISysMenuService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author oldwei
 * @date 2021-7-23 16:43
 */
@Slf4j
@Service
@RequiredArgsConstructor
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenu> implements ISysMenuService {

    @Override
    public List<SysMenu> menuTree() {
        LambdaQueryWrapper<SysMenu> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper
                .eq(SysMenu::getParentId, 0)
                .or()
                .isNull(SysMenu::getParentId)
                .orderByDesc(SysMenu::getSortNum);
        List<SysMenu> list = this.list(queryWrapper);
        if (list.size() > 0) {
            list.forEach(this::findAllChild);
        }
        return list;
    }
    public void findAllChild(SysMenu sysMenu ) {
        LambdaQueryWrapper<SysMenu> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        lambdaQueryWrapper.eq(SysMenu::getParentId, sysMenu.getId()).orderByDesc(SysMenu::getSortNum);
        // 首次进入这个方法时，查出的是二级节点列表
        // 递归调用时，就能依次查出三、四、五等等级别的节点列表，
        // 递归能实现不同节点级别的无限调用,这个层次不易太深，否则有性能问题
        List<SysMenu> sysMenuList = this.list(lambdaQueryWrapper);
        if (sysMenuList.size() > 0) {
            sysMenu.setChildren(sysMenuList);
            sysMenuList.forEach(this::findAllChild);
        }
    }
}
