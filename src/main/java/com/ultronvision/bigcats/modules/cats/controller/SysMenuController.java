package com.ultronvision.bigcats.modules.cats.controller;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.ultronvision.bigcats.common.api.vo.ResultResponse;
import com.ultronvision.bigcats.modules.cats.entity.pojo.SysMenu;
import com.ultronvision.bigcats.modules.cats.service.ISysMenuService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

/**
 * @author oldwei
 * @date 2021/6/1 10:26 下午
 */
@Slf4j
@RestController
@RequestMapping("sys/menu")
@RequiredArgsConstructor
public class SysMenuController {
    private final ISysMenuService sysMenuService;

    @GetMapping("tree")
    public JSONObject menuTree() {
        List<SysMenu> sysMenuList = this.sysMenuService.menuTree();
        JSONObject result = new JSONObject();
        result.put("result", sysMenuList);
        return result;
    }

    /**
     * 动态路由
     *
     * @return 路由列表
     */
    @GetMapping("nav")
    public JSONObject nav() {
        List<SysMenu> list = this.sysMenuService.list();
        JSONObject result = new JSONObject();
        result.put("result", list);
        return result;
    }

    /**
     * 添加路由
     *
     * @param sysMenu 路由信息
     * @return 是否成功
     */
    @PostMapping
    public Boolean addMenu(@RequestBody SysMenu sysMenu) {
        return this.sysMenuService.save(sysMenu);
    }

    @DeleteMapping
    public ResultResponse<JSONObject> deleteMenu(@RequestBody String menuIds) {
        String[] ids = menuIds.split(StringPool.COMMA);
        List<String> list = Arrays.asList(ids);
        // 判断哪些菜单有子菜单，哪些没有
        List<Long> hasChildren = this.sysMenuService.hasChildren(list);
        if (hasChildren.size() > 0) {
            log.error("菜单 {} 存在子菜单，不允许删除", hasChildren);
            return ResultResponse.error("菜单 " + hasChildren + " 存在子菜单，不允许删除");
        }
        this.sysMenuService.removeByIds(list);
        return ResultResponse.ok("删除成功");
    }
}
