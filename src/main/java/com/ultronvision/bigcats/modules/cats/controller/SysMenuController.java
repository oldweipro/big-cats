package com.ultronvision.bigcats.modules.cats.controller;

import cn.hutool.json.JSONObject;
import com.ultronvision.bigcats.common.entity.BaseController;
import com.ultronvision.bigcats.common.entity.cats.SysMenu;
import com.ultronvision.bigcats.modules.cats.service.ISysMenuService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author oldwei
 * @date 2021/6/1 10:26 下午
 */
@Slf4j
@RestController
@RequestMapping("sys/menu")
@RequiredArgsConstructor
public class SysMenuController extends BaseController {
    private final ISysMenuService sysMenuService;

    @GetMapping("tree")
    public JSONObject menuTree() {
        List<SysMenu> sysMenuList = this.sysMenuService.menuTree();
        JSONObject result = new JSONObject();
        result.set("result", sysMenuList);
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
        result.set("result", list);
        return result;
//        String navStr = "[\n" +
//                "    {\n" +
//                "      \"name\": \"form\",\n" +
//                "      \"parentId\": \"0\",\n" +
//                "      \"id\": 10,\n" +
//                "      \"meta\": {\n" +
//                "        \"icon\": \"form\",\n" +
//                "        \"title\": \"表单页\"\n" +
//                "      },\n" +
//                "      \"redirect\": \"/form/base-form\",\n" +
//                "      \"component\": \"PageView\"\n" +
//                "    },\n" +
//                "    {\n" +
//                "      \"name\": \"basic-form\",\n" +
//                "      \"parentId\": 10,\n" +
//                "      \"id\": 6,\n" +
//                "      \"meta\": {\n" +
//                "        \"title\": \"基础表单\"\n" +
//                "      },\n" +
//                "      \"component\": \"BasicForm\"\n" +
//                "    },\n" +
//                "    {\n" +
//                "      \"name\": \"step-form\",\n" +
//                "      \"parentId\": 10,\n" +
//                "      \"id\": 5,\n" +
//                "      \"meta\": {\n" +
//                "        \"title\": \"分步表单\"\n" +
//                "      },\n" +
//                "      \"component\": \"StepForm\"\n" +
//                "    },\n" +
//                "    {\n" +
//                "      \"name\": \"advanced-form\",\n" +
//                "      \"parentId\": 10,\n" +
//                "      \"id\": 4,\n" +
//                "      \"meta\": {\n" +
//                "        \"title\": \"高级表单\"\n" +
//                "      },\n" +
//                "      \"component\": \"AdvanceForm\"\n" +
//                "    },\n" +
//                "    {\n" +
//                "      \"name\": \"list\",\n" +
//                "      \"parentId\": \"0\",\n" +
//                "      \"id\": 10010,\n" +
//                "      \"meta\": {\n" +
//                "        \"icon\": \"table\",\n" +
//                "        \"title\": \"列表页\",\n" +
//                "        \"show\": true\n" +
//                "      },\n" +
//                "      \"redirect\": \"/list/table-list\",\n" +
//                "      \"component\": \"PageView\"\n" +
//                "    },\n" +
//                "    {\n" +
//                "      \"name\": \"table-list\",\n" +
//                "      \"parentId\": 10010,\n" +
//                "      \"id\": 10011,\n" +
//                "      \"path\": \"/list/table-list/:pageNo([1-9]\\\\d*)?\",\n" +
//                "      \"meta\": {\n" +
//                "        \"title\": \"查询表格\",\n" +
//                "        \"show\": true\n" +
//                "      },\n" +
//                "      \"component\": \"TableList\"\n" +
//                "    },\n" +
//                "    {\n" +
//                "      \"name\": \"basic-list\",\n" +
//                "      \"parentId\": 10010,\n" +
//                "      \"id\": 10012,\n" +
//                "      \"meta\": {\n" +
//                "        \"title\": \"标准列表\",\n" +
//                "        \"show\": true\n" +
//                "      },\n" +
//                "      \"component\": \"StandardList\"\n" +
//                "    },\n" +
//                "    {\n" +
//                "      \"name\": \"card\",\n" +
//                "      \"parentId\": 10010,\n" +
//                "      \"id\": 10013,\n" +
//                "      \"meta\": {\n" +
//                "        \"title\": \"卡片列表\",\n" +
//                "        \"show\": true\n" +
//                "      },\n" +
//                "      \"component\": \"CardList\"\n" +
//                "    },\n" +
//                "    {\n" +
//                "      \"name\": \"search\",\n" +
//                "      \"parentId\": 10010,\n" +
//                "      \"id\": 10014,\n" +
//                "      \"meta\": {\n" +
//                "        \"title\": \"搜索列表\",\n" +
//                "        \"show\": true\n" +
//                "      },\n" +
//                "      \"redirect\": \"/list/search/article\",\n" +
//                "      \"component\": \"SearchLayout\"\n" +
//                "    },\n" +
//                "    {\n" +
//                "      \"name\": \"article\",\n" +
//                "      \"parentId\": 10014,\n" +
//                "      \"id\": 10015,\n" +
//                "      \"meta\": {\n" +
//                "        \"title\": \"搜索列表（文章）\",\n" +
//                "        \"show\": true\n" +
//                "      },\n" +
//                "      \"component\": \"SearchArticles\"\n" +
//                "    },\n" +
//                "    {\n" +
//                "      \"name\": \"project\",\n" +
//                "      \"parentId\": 10014,\n" +
//                "      \"id\": 10016,\n" +
//                "      \"meta\": {\n" +
//                "        \"title\": \"搜索列表（项目）\",\n" +
//                "        \"show\": true\n" +
//                "      },\n" +
//                "      \"component\": \"SearchProjects\"\n" +
//                "    },\n" +
//                "    {\n" +
//                "      \"name\": \"application\",\n" +
//                "      \"parentId\": 10014,\n" +
//                "      \"id\": 10017,\n" +
//                "      \"meta\": {\n" +
//                "        \"title\": \"搜索列表（应用）\",\n" +
//                "        \"show\": true\n" +
//                "      },\n" +
//                "      \"component\": \"SearchApplications\"\n" +
//                "    },\n" +
//                "    {\n" +
//                "      \"name\": \"profile\",\n" +
//                "      \"parentId\": \"0\",\n" +
//                "      \"id\": 10018,\n" +
//                "      \"meta\": {\n" +
//                "        \"title\": \"详情页\",\n" +
//                "        \"icon\": \"profile\",\n" +
//                "        \"show\": true\n" +
//                "      },\n" +
//                "      \"redirect\": \"/profile/basic\",\n" +
//                "      \"component\": \"RouteView\"\n" +
//                "    },\n" +
//                "    {\n" +
//                "      \"name\": \"basic\",\n" +
//                "      \"parentId\": 10018,\n" +
//                "      \"id\": 10019,\n" +
//                "      \"meta\": {\n" +
//                "        \"title\": \"基础详情页\",\n" +
//                "        \"show\": true\n" +
//                "      },\n" +
//                "      \"component\": \"ProfileBasic\"\n" +
//                "    },\n" +
//                "    {\n" +
//                "      \"name\": \"advanced\",\n" +
//                "      \"parentId\": 10018,\n" +
//                "      \"id\": 10020,\n" +
//                "      \"meta\": {\n" +
//                "        \"title\": \"高级详情页\",\n" +
//                "        \"show\": true\n" +
//                "      },\n" +
//                "      \"component\": \"ProfileAdvanced\"\n" +
//                "    },\n" +
//                "    {\n" +
//                "      \"name\": \"result\",\n" +
//                "      \"parentId\": \"0\",\n" +
//                "      \"id\": 10021,\n" +
//                "      \"meta\": {\n" +
//                "        \"title\": \"结果页\",\n" +
//                "        \"icon\": \"check-circle-o\",\n" +
//                "        \"show\": true\n" +
//                "      },\n" +
//                "      \"redirect\": \"/result/success\",\n" +
//                "      \"component\": \"PageView\"\n" +
//                "    },\n" +
//                "    {\n" +
//                "      \"name\": \"success\",\n" +
//                "      \"parentId\": 10021,\n" +
//                "      \"id\": 10022,\n" +
//                "      \"meta\": {\n" +
//                "        \"title\": \"成功\",\n" +
//                "        \"hiddenHeaderContent\": true,\n" +
//                "        \"show\": true\n" +
//                "      },\n" +
//                "      \"component\": \"ResultSuccess\"\n" +
//                "    },\n" +
//                "    {\n" +
//                "      \"name\": \"fail\",\n" +
//                "      \"parentId\": 10021,\n" +
//                "      \"id\": 10023,\n" +
//                "      \"meta\": {\n" +
//                "        \"title\": \"失败\",\n" +
//                "        \"hiddenHeaderContent\": true,\n" +
//                "        \"show\": true\n" +
//                "      },\n" +
//                "      \"component\": \"ResultFail\"\n" +
//                "    },\n" +
//                "    {\n" +
//                "      \"name\": \"exception\",\n" +
//                "      \"parentId\": \"0\",\n" +
//                "      \"id\": 10024,\n" +
//                "      \"meta\": {\n" +
//                "        \"title\": \"异常页\",\n" +
//                "        \"icon\": \"warning\",\n" +
//                "        \"show\": true\n" +
//                "      },\n" +
//                "      \"redirect\": \"/exception/403\",\n" +
//                "      \"component\": \"RouteView\"\n" +
//                "    },\n" +
//                "    {\n" +
//                "      \"name\": \"403\",\n" +
//                "      \"parentId\": 10024,\n" +
//                "      \"id\": 10025,\n" +
//                "      \"meta\": {\n" +
//                "        \"title\": \"403\",\n" +
//                "        \"show\": true\n" +
//                "      },\n" +
//                "      \"component\": \"Exception403\"\n" +
//                "    },\n" +
//                "    {\n" +
//                "      \"name\": \"404\",\n" +
//                "      \"parentId\": 10024,\n" +
//                "      \"id\": 10026,\n" +
//                "      \"meta\": {\n" +
//                "        \"title\": \"404\",\n" +
//                "        \"show\": true\n" +
//                "      },\n" +
//                "      \"component\": \"Exception404\"\n" +
//                "    },\n" +
//                "    {\n" +
//                "      \"name\": \"500\",\n" +
//                "      \"parentId\": 10024,\n" +
//                "      \"id\": 10027,\n" +
//                "      \"meta\": {\n" +
//                "        \"title\": \"500\",\n" +
//                "        \"show\": true\n" +
//                "      },\n" +
//                "      \"component\": \"Exception500\"\n" +
//                "    },\n" +
//                "    {\n" +
//                "      \"name\": \"account\",\n" +
//                "      \"parentId\": \"0\",\n" +
//                "      \"id\": 10028,\n" +
//                "      \"meta\": {\n" +
//                "        \"title\": \"个人页\",\n" +
//                "        \"icon\": \"user\",\n" +
//                "        \"show\": true\n" +
//                "      },\n" +
//                "      \"redirect\": \"/account/center\",\n" +
//                "      \"component\": \"RouteView\"\n" +
//                "    },\n" +
//                "    {\n" +
//                "      \"name\": \"center\",\n" +
//                "      \"parentId\": 10028,\n" +
//                "      \"id\": 10029,\n" +
//                "      \"meta\": {\n" +
//                "        \"title\": \"个人中心\",\n" +
//                "        \"show\": true\n" +
//                "      },\n" +
//                "      \"component\": \"AccountCenter\"\n" +
//                "    },\n" +
//                "    {\n" +
//                "      \"name\": \"settings\",\n" +
//                "      \"parentId\": 10028,\n" +
//                "      \"id\": 10030,\n" +
//                "      \"meta\": {\n" +
//                "        \"title\": \"个人设置\",\n" +
//                "        \"hideHeader\": true,\n" +
//                "        \"hideChildren\": false,\n" +
//                "        \"show\": true\n" +
//                "      },\n" +
//                "      \"redirect\": \"/account/settings/base\",\n" +
//                "      \"component\": \"AccountSettings\"\n" +
//                "    },\n" +
//                "    {\n" +
//                "      \"name\": \"BaseSettings\",\n" +
//                "      \"path\": \"/account/settings/base\",\n" +
//                "      \"parentId\": 10030,\n" +
//                "      \"id\": 10031,\n" +
//                "      \"meta\": {\n" +
//                "        \"title\": \"基本设置\",\n" +
//                "        \"show\": true\n" +
//                "      },\n" +
//                "      \"component\": \"BaseSettings\"\n" +
//                "    },\n" +
//                "    {\n" +
//                "      \"name\": \"SecuritySettings\",\n" +
//                "      \"path\": \"/account/settings/security\",\n" +
//                "      \"parentId\": 10030,\n" +
//                "      \"id\": 10032,\n" +
//                "      \"meta\": {\n" +
//                "        \"title\": \"安全设置\",\n" +
//                "        \"show\": true\n" +
//                "      },\n" +
//                "      \"component\": \"SecuritySettings\"\n" +
//                "    },\n" +
//                "    {\n" +
//                "      \"name\": \"CustomSettings\",\n" +
//                "      \"path\": \"/account/settings/custom\",\n" +
//                "      \"parentId\": 10030,\n" +
//                "      \"id\": 10033,\n" +
//                "      \"meta\": {\n" +
//                "        \"title\": \"个性化设置\",\n" +
//                "        \"show\": true\n" +
//                "      },\n" +
//                "      \"component\": \"CustomSettings\"\n" +
//                "    },\n" +
//                "    {\n" +
//                "      \"name\": \"BindingSettings\",\n" +
//                "      \"path\": \"/account/settings/binding\",\n" +
//                "      \"parentId\": 10030,\n" +
//                "      \"id\": 10034,\n" +
//                "      \"meta\": {\n" +
//                "        \"title\": \"账户绑定\",\n" +
//                "        \"show\": true\n" +
//                "      },\n" +
//                "      \"component\": \"BindingSettings\"\n" +
//                "    },\n" +
//                "    {\n" +
//                "      \"name\": \"NotificationSettings\",\n" +
//                "      \"path\": \"/account/settings/notification\",\n" +
//                "      \"parentId\": 10030,\n" +
//                "      \"id\": 10034,\n" +
//                "      \"meta\": {\n" +
//                "        \"title\": \"新消息通知\",\n" +
//                "        \"show\": true\n" +
//                "      },\n" +
//                "      \"component\": \"NotificationSettings\"\n" +
//                "    },\n" +
//                "    {\n" +
//                "      \"name\": \"cats\",\n" +
//                "      \"parentId\": \"0\",\n" +
//                "      \"id\": 10035,\n" +
//                "      \"meta\": {\n" +
//                "        \"title\": \"系统设置\",\n" +
//                "        \"icon\": \"user\",\n" +
//                "        \"show\": true\n" +
//                "      },\n" +
//                "      \"redirect\": \"/account/center\",\n" +
//                "      \"component\": \"RouteView\"\n" +
//                "    },\n" +
//                "    {\n" +
//                "      \"key\": \"sys-user\",\n" +
//                "      \"parentId\": 10035,\n" +
//                "      \"id\": 10036,\n" +
//                "      \"meta\": {\n" +
//                "        \"title\": \"用户管理\",\n" +
//                "        \"show\": true\n" +
//                "      },\n" +
//                "      \"path\": \"sysUser\",\n" +
//                "      \"component\": \"cats/sysUser/SysUser\"\n" +
//                "    },\n" +
//                "    {\n" +
//                "      \"name\": \"sys-menu\",\n" +
//                "      \"parentId\": 10035,\n" +
//                "      \"id\": 10037,\n" +
//                "      \"meta\": {\n" +
//                "        \"title\": \"菜单管理\",\n" +
//                "        \"show\": true\n" +
//                "      },\n" +
//                "      \"component\": \"cats/sysMenu/SysMenu\"\n" +
//                "    }\n" +
//                "  ]";
//        JSONObject result = new JSONObject();
//        JSONArray array = JSONArray.parseArray(navStr);
//        result.put("result", array);
//        return result;
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
}
