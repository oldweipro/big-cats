package com.ultronvision.bigcats.modules.cats.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.ultronvision.bigcats.modules.cats.entity.SysMenu;

import java.util.List;

/**
 * @author oldwei
 * @date 2021-7-23 16:42
 */
public interface ISysMenuService extends IService<SysMenu> {

    List<SysMenu> menuTree();
}
