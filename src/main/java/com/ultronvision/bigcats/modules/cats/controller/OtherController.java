package com.ultronvision.bigcats.modules.cats.controller;

import cn.hutool.core.date.DateField;
import cn.hutool.core.date.DateTime;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author oldwei
 * @date 2021/6/1 11:31 下午
 */
@RestController
@RequestMapping("other")
@RequiredArgsConstructor
public class OtherController {

    @GetMapping("service")
    public JSONObject service(@RequestParam(defaultValue = "1") double pageNo, @RequestParam(defaultValue = "10") double pageSize) {
        int totalCount = 5701;
        JSONArray result = new JSONArray();
        double totalPage = Math.ceil(totalCount / pageSize);
        double key = (pageNo - 1) * pageSize;
        double next = (pageNo >= totalPage ? (totalCount % pageSize) : pageSize) + 1;

        for (int i = 1; i < next; i++) {
            double tmpKey = key + i;
            JSONObject object = new JSONObject();
            object.set("key", tmpKey);
            object.set("id", tmpKey);
            object.set("no", "No " + tmpKey);
            object.set("description", "这是一段描述");
            object.set("callNo", RandomUtil.randomInt(1, 999));
            object.set("status", RandomUtil.randomInt(0, 3));
            object.set("updatedAt", RandomUtil.randomDate(DateTime.now(), DateField.DAY_OF_YEAR, 1994, 2021));
            object.set("editable", false);
            result.add(object);
        }
        JSONObject data = new JSONObject();
        data.set("pageSize", pageSize);
        data.set("pageNo", pageNo);
        data.set("totalCount", totalCount);
        data.set("totalPage", totalPage);
        data.set("data", result);
        JSONObject builder = new JSONObject();
        builder.set("result", data);
        return builder;
    }

    @GetMapping("list/search/projects")
    public JSONObject listSearchProjects() {
        String projectsStr = "{\n" +
                "    \"data\": [{\n" +
                "      id: 1,\n" +
                "      cover: \"https://gw.alipayobjects.com/zos/rmsportal/WdGqmHpayyMjiEhcKoVE.png\",\n" +
                "      title: \"Alipay\",\n" +
                "      description: \"那是一种内在的东西， 他们到达不了，也无法触及的\",\n" +
                "      status: 1,\n" +
                "      updatedAt: \"2018-07-26 00:00:00\"\n" +
                "    },\n" +
                "    {\n" +
                "      id: 2,\n" +
                "      cover: \"https://gw.alipayobjects.com/zos/rmsportal/zOsKZmFRdUtvpqCImOVY.png\",\n" +
                "      title: \"Angular\",\n" +
                "      description: \"希望是一个好东西，也许是最好的，好东西是不会消亡的\",\n" +
                "      status: 1,\n" +
                "      updatedAt: \"2018-07-26 00:00:00\"\n" +
                "    },\n" +
                "    {\n" +
                "      id: 3,\n" +
                "      cover: \"https://gw.alipayobjects.com/zos/rmsportal/dURIMkkrRFpPgTuzkwnB.png\",\n" +
                "      title: \"Ant Design\",\n" +
                "      description: \"城镇中有那么多的酒馆，她却偏偏走进了我的酒馆\",\n" +
                "      status: 1,\n" +
                "      updatedAt: \"2018-07-26 00:00:00\"\n" +
                "    },\n" +
                "    {\n" +
                "      id: 4,\n" +
                "      cover: \"https://gw.alipayobjects.com/zos/rmsportal/sfjbOqnsXXJgNCjCzDBL.png\",\n" +
                "      title: \"Ant Design Pro\",\n" +
                "      description: \"那时候我只会想自己想要什么，从不想自己拥有什么\",\n" +
                "      status: 1,\n" +
                "      updatedAt: \"2018-07-26 00:00:00\"\n" +
                "    },\n" +
                "    {\n" +
                "      id: 5,\n" +
                "      cover: \"https://gw.alipayobjects.com/zos/rmsportal/siCrBXXhmvTQGWPNLBow.png\",\n" +
                "      title: \"Bootstrap\",\n" +
                "      description: \"凛冬将至\",\n" +
                "      status: 1,\n" +
                "      updatedAt: \"2018-07-26 00:00:00\"\n" +
                "    },\n" +
                "    {\n" +
                "      id: 6,\n" +
                "      cover: \"https://gw.alipayobjects.com/zos/rmsportal/ComBAopevLwENQdKWiIn.png\",\n" +
                "      title: \"Vue\",\n" +
                "      description: \"生命就像一盒巧克力，结果往往出人意料\",\n" +
                "      status: 1,\n" +
                "      updatedAt: \"2018-07-26 00:00:00\"\n" +
                "    }\n" +
                "    ],\n" +
                "    \"pageSize\": 10,\n" +
                "    \"pageNo\": 0,\n" +
                "    \"totalPage\": 6,\n" +
                "    \"totalCount\": 57\n" +
                "  }";
        JSONObject projects = JSONUtil.parseObj(projectsStr);
        JSONObject result = new JSONObject();
        result.set("result", projects);
        return result;
    }

    @GetMapping("workplace/activity")
    public JSONObject workplaceActivity() {
        String activityStr = "[{\n" +
                "    id: 1,\n" +
                "    user: {\n" +
                "      nickname: \"@name\",\n" +
                "      avatar: \"https://gw.alipayobjects.com/zos/rmsportal/BiazfanxmamNRoxxVxka.png\"\n" +
                "    },\n" +
                "    project: {\n" +
                "      name: \"白鹭酱油开发组\",\n" +
                "      action: \"更新\",\n" +
                "      event: \"番组计划\"\n" +
                "    },\n" +
                "    time: \"2018-08-23 14:47:00\"\n" +
                "  },\n" +
                "  {\n" +
                "    id: 1,\n" +
                "    user: {\n" +
                "      nickname: \"蓝莓酱\",\n" +
                "      avatar: \"https://gw.alipayobjects.com/zos/rmsportal/jZUIxmJycoymBprLOUbT.png\"\n" +
                "    },\n" +
                "    project: {\n" +
                "      name: \"白鹭酱油开发组\",\n" +
                "      action: \"更新\",\n" +
                "      event: \"番组计划\"\n" +
                "    },\n" +
                "    time: \"2018-08-23 09:35:37\"\n" +
                "  },\n" +
                "  {\n" +
                "    id: 1,\n" +
                "    user: {\n" +
                "      nickname: \"@name\",\n" +
                "      avatar: \"@image(64x64)\"\n" +
                "    },\n" +
                "    project: {\n" +
                "      name: \"白鹭酱油开发组\",\n" +
                "      action: \"创建\",\n" +
                "      event: \"番组计划\"\n" +
                "    },\n" +
                "    time: \"2017-05-27 00:00:00\"\n" +
                "  },\n" +
                "  {\n" +
                "    id: 1,\n" +
                "    user: {\n" +
                "      nickname: \"曲丽丽\",\n" +
                "      avatar: \"@image(64x64)\"\n" +
                "    },\n" +
                "    project: {\n" +
                "      name: \"高逼格设计天团\",\n" +
                "      action: \"更新\",\n" +
                "      event: \"六月迭代\"\n" +
                "    },\n" +
                "    time: \"2018-08-23 14:47:00\"\n" +
                "  },\n" +
                "  {\n" +
                "    id: 1,\n" +
                "    user: {\n" +
                "      nickname: \"@name\",\n" +
                "      avatar: \"@image(64x64)\"\n" +
                "    },\n" +
                "    project: {\n" +
                "      name: \"高逼格设计天团\",\n" +
                "      action: \"created\",\n" +
                "      event: \"六月迭代\"\n" +
                "    },\n" +
                "    time: \"2018-08-23 14:47:00\"\n" +
                "  },\n" +
                "  {\n" +
                "    id: 1,\n" +
                "    user: {\n" +
                "      nickname: \"曲丽丽\",\n" +
                "      avatar: \"https://gw.alipayobjects.com/zos/rmsportal/BiazfanxmamNRoxxVxka.png\"\n" +
                "    },\n" +
                "    project: {\n" +
                "      name: \"高逼格设计天团\",\n" +
                "      action: \"created\",\n" +
                "      event: \"六月迭代\"\n" +
                "    },\n" +
                "    time: \"2018-08-23 14:47:00\"\n" +
                "  }\n" +
                "  ]";
        JSONArray activity = JSONUtil.parseArray(activityStr);
        JSONObject result = new JSONObject();
        result.set("result", activity);
        return result;
    }

    @GetMapping("workplace/teams")
    public JSONObject workplaceTeams() {
        String teamsStr = "[{\n" +
                "    id: 1,\n" +
                "    name: \"科学搬砖组\",\n" +
                "    avatar: \"https://gw.alipayobjects.com/zos/rmsportal/BiazfanxmamNRoxxVxka.png\"\n" +
                "  },\n" +
                "  {\n" +
                "    id: 2,\n" +
                "    name: \"程序员日常\",\n" +
                "    avatar: \"https://gw.alipayobjects.com/zos/rmsportal/cnrhVkzwxjPwAaCfPbdc.png\"\n" +
                "  },\n" +
                "  {\n" +
                "    id: 1,\n" +
                "    name: \"设计天团\",\n" +
                "    avatar: \"https://gw.alipayobjects.com/zos/rmsportal/gaOngJwsRYRaVAuXXcmB.png\"\n" +
                "  },\n" +
                "  {\n" +
                "    id: 1,\n" +
                "    name: \"中二少女团\",\n" +
                "    avatar: \"https://gw.alipayobjects.com/zos/rmsportal/ubnKSIfAJTxIgXOKlciN.png\"\n" +
                "  },\n" +
                "  {\n" +
                "    id: 1,\n" +
                "    name: \"骗你学计算机\",\n" +
                "    avatar: \"https://gw.alipayobjects.com/zos/rmsportal/WhxKECPNujWoWEFNdnJE.png\"\n" +
                "  }\n" +
                "  ]";
        JSONArray teams = JSONUtil.parseArray(teamsStr);
        JSONObject result = new JSONObject();
        result.set("result", teams);
        return result;
    }

    @GetMapping("workplace/radar")
    public JSONObject workplaceRadar() {
        String radarStr = "[{\n" +
                "    item: \"引用\",\n" +
                "    \"个人\": 70,\n" +
                "    \"团队\": 30,\n" +
                "    \"部门\": 40\n" +
                "  },\n" +
                "  {\n" +
                "    item: \"口碑\",\n" +
                "    \"个人\": 60,\n" +
                "    \"团队\": 70,\n" +
                "    \"部门\": 40\n" +
                "  },\n" +
                "  {\n" +
                "    item: \"产量\",\n" +
                "    \"个人\": 50,\n" +
                "    \"团队\": 60,\n" +
                "    \"部门\": 40\n" +
                "  },\n" +
                "  {\n" +
                "    item: \"贡献\",\n" +
                "    \"个人\": 40,\n" +
                "    \"团队\": 50,\n" +
                "    \"部门\": 40\n" +
                "  },\n" +
                "  {\n" +
                "    item: \"热度\",\n" +
                "    \"个人\": 60,\n" +
                "    \"团队\": 70,\n" +
                "    \"部门\": 40\n" +
                "  },\n" +
                "  {\n" +
                "    item: \"引用\",\n" +
                "    \"个人\": 70,\n" +
                "    \"团队\": 50,\n" +
                "    \"部门\": 40\n" +
                "  }\n" +
                "  ]";
        JSONArray radar = JSONUtil.parseArray(radarStr);
        JSONObject result = new JSONObject();
        result.set("result", radar);
        return result;
    }

    @GetMapping("permissions")
    public JSONObject permissions() {
        String permissions = "{" +
                "\"data\": [{\n" +
                "      \"id\": \"marketing\",\n" +
                "      \"name\": \"营销管理\",\n" +
                "      \"describe\": \"\",\n" +
                "      \"status\": 1,\n" +
                "      \"actionData\": [{\"action\":\"query\",\"defaultCheck\":false,\"describe\":\"查询\"},{\"action\":\"get\",\"defaultCheck\":false,\"describe\":\"详情\"},{\"action\":\"add\",\"defaultCheck\":false,\"describe\":\"新增\"},{\"action\":\"edit\",\"defaultCheck\":false,\"describe\":\"修改\"},{\"action\":\"delete\",\"defaultCheck\":false,\"describe\":\"删除\"}],\n" +
                "      \"sptDaTypes\": \"\",\n" +
                "      \"optionalFields\": \"\",\n" +
                "      \"parents\": \"\",\n" +
                "      \"type\": \"\",\n" +
                "      \"deleted\": 0,\n" +
                "      \"actions\": [\n" +
                "        \"add\",\n" +
                "        \"query\",\n" +
                "        \"get\",\n" +
                "        \"edit\",\n" +
                "        \"delete\"\n" +
                "      ]\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"member\",\n" +
                "      \"name\": \"会员管理\",\n" +
                "      \"describe\": \"\",\n" +
                "      \"status\": 1,\n" +
                "      \"actionData\": [{\"action\":\"query\",\"defaultCheck\":false,\"describe\":\"查询\"},{\"action\":\"get\",\"defaultCheck\":false,\"describe\":\"详情\"},{\"action\":\"add\",\"defaultCheck\":false,\"describe\":\"新增\"},{\"action\":\"edit\",\"defaultCheck\":false,\"describe\":\"修改\"},{\"action\":\"delete\",\"defaultCheck\":false,\"describe\":\"删除\"}],\n" +
                "      \"sptDaTypes\": \"\",\n" +
                "      \"optionalFields\": [],\n" +
                "      \"parents\": \"\",\n" +
                "      \"type\": \"default\",\n" +
                "      \"deleted\": 0,\n" +
                "      \"actions\": [\n" +
                "        \"add\",\n" +
                "        \"query\",\n" +
                "        \"get\",\n" +
                "        \"edit\",\n" +
                "        \"delete\"\n" +
                "      ]\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"menu\",\n" +
                "      \"name\": \"菜单管理\",\n" +
                "      \"describe\": \"\",\n" +
                "      \"status\": 1,\n" +
                "      \"actionData\": [{\"action\":\"add\",\"defaultCheck\":false,\"describe\":\"新增\"},{\"action\":\"import\",\"defaultCheck\":false,\"describe\":\"导入\"},{\"action\":\"get\",\"defaultCheck\":false,\"describe\":\"查询\"},{\"action\":\"edit\",\"defaultCheck\":false,\"describe\":\"修改\"}],\n" +
                "      \"sptDaTypes\": \"\",\n" +
                "      \"optionalFields\": [],\n" +
                "      \"parents\": \"\",\n" +
                "      \"type\": \"default\",\n" +
                "      \"deleted\": 0,\n" +
                "      \"actions\": [\n" +
                "        \"add\",\n" +
                "        \"import\",\n" +
                "        \"get\",\n" +
                "        \"edit\"\n" +
                "      ]\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"order\",\n" +
                "      \"name\": \"订单管理\",\n" +
                "      \"describe\": \"\",\n" +
                "      \"status\": 1,\n" +
                "      \"actionData\": [{\"action\":\"query\",\"defaultCheck\":false,\"describe\":\"查询\"},{\"action\":\"get\",\"defaultCheck\":false,\"describe\":\"详情\"},{\"action\":\"add\",\"defaultCheck\":false,\"describe\":\"新增\"},{\"action\":\"edit\",\"defaultCheck\":false,\"describe\":\"修改\"},{\"action\":\"delete\",\"defaultCheck\":false,\"describe\":\"删除\"}],\n" +
                "      \"sptDaTypes\": \"\",\n" +
                "      \"optionalFields\": [],\n" +
                "      \"parents\": \"\",\n" +
                "      \"type\": \"default\",\n" +
                "      \"deleted\": 0,\n" +
                "      \"actions\": [\n" +
                "        \"add\",\n" +
                "        \"query\",\n" +
                "        \"get\",\n" +
                "        \"edit\",\n" +
                "        \"delete\"\n" +
                "      ]\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"permission\",\n" +
                "      \"name\": \"权限管理\",\n" +
                "      \"describe\": \"\",\n" +
                "      \"status\": 1,\n" +
                "      \"actionData\": [{\"action\":\"add\",\"defaultCheck\":false,\"describe\":\"新增\"},{\"action\":\"get\",\"defaultCheck\":false,\"describe\":\"查询\"},{\"action\":\"edit\",\"defaultCheck\":false,\"describe\":\"修改\"},{\"action\":\"delete\",\"defaultCheck\":false,\"describe\":\"删除\"}],\n" +
                "      \"sptDaTypes\": \"\",\n" +
                "      \"optionalFields\": [],\n" +
                "      \"parents\": \"\",\n" +
                "      \"type\": \"default\",\n" +
                "      \"deleted\": 0,\n" +
                "      \"actions\": [\n" +
                "        \"add\",\n" +
                "        \"get\",\n" +
                "        \"edit\",\n" +
                "        \"delete\"\n" +
                "      ]\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"role\",\n" +
                "      \"name\": \"角色管理\",\n" +
                "      \"describe\": \"\",\n" +
                "      \"status\": 1,\n" +
                "      \"actionData\": [{\"action\":\"add\",\"defaultCheck\":false,\"describe\":\"新增\"},{\"action\":\"get\",\"defaultCheck\":false,\"describe\":\"查询\"},{\"action\":\"edit\",\"defaultCheck\":false,\"describe\":\"修改\"},{\"action\":\"delete\",\"defaultCheck\":false,\"describe\":\"删除\"}],\n" +
                "      \"sptDaTypes\": \"\",\n" +
                "      \"optionalFields\": [],\n" +
                "      \"parents\": \"\",\n" +
                "      \"type\": \"default\",\n" +
                "      \"deleted\": 0,\n" +
                "      \"actions\": [\n" +
                "        \"add\",\n" +
                "        \"get\",\n" +
                "        \"edit\",\n" +
                "        \"delete\"\n" +
                "      ]\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"test\",\n" +
                "      \"name\": \"测试权限\",\n" +
                "      \"describe\": \"\",\n" +
                "      \"status\": 1,\n" +
                "      \"actionData\": [{\"action\":\"add\",\"defaultCheck\":false,\"describe\":\"新增\"},{\"action\":\"get\",\"defaultCheck\":false,\"describe\":\"详情\"}],\n" +
                "      \"sptDaTypes\": \"\",\n" +
                "      \"optionalFields\": [],\n" +
                "      \"parents\": \"\",\n" +
                "      \"type\": \"default\",\n" +
                "      \"deleted\": 0,\n" +
                "      \"actions\": [\n" +
                "        \"add\",\n" +
                "        \"get\"\n" +
                "      ]\n" +
                "    },\n" +
                "    {\n" +
                "      \"id\": \"user\",\n" +
                "      \"name\": \"用户管理\",\n" +
                "      \"describe\": \"\",\n" +
                "      \"status\": 1,\n" +
                "      \"actionData\": [{\"action\":\"add\",\"describe\":\"新增\",\"defaultCheck\":false},{\"action\":\"get\",\"describe\":\"查询\",\"defaultCheck\":false}],\n" +
                "      \"sptDaTypes\": \"\",\n" +
                "      \"optionalFields\": [],\n" +
                "      \"parents\": \"\",\n" +
                "      \"type\": \"default\",\n" +
                "      \"deleted\": 0,\n" +
                "      \"actions\": [\n" +
                "        \"add\",\n" +
                "        \"get\"\n" +
                "      ]\n" +
                "    }\n" +
                "    ],\n" +
                "    \"pageSize\": 10,\n" +
                "    \"pageNo\": 0,\n" +
                "    \"totalPage\": 1,\n" +
                "    \"totalCount\": 5\n" +
                "}";
        JSONObject radar = JSONUtil.parseObj(permissions);
        JSONObject result = new JSONObject();
        result.set("result", radar);
        return result;
    }
}
