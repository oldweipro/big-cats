package com.ultronvision.bigcats.modules.cats.controller;

import com.alibaba.fastjson.JSONObject;
import com.ultronvision.bigcats.common.entity.BaseController;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 用户相关
 *
 * @author oldwei
 * @date 2021/6/1 4:52 下午
 */
@Slf4j
@RestController
@RequestMapping("user")
@RequiredArgsConstructor
public class SysUserController extends BaseController {
    /**
     * 获取用户信息
     *
     * @return
     */
    @GetMapping("info")
    public JSONObject info() {
        String userInfoStr = "{\n" +
                "    \"id\": \"4291d7da9005377ec9aec4a71ea837f\",\n" +
                "    \"name\": \"天野远子\",\n" +
                "    \"username\": \"admin\",\n" +
                "    \"password\": null,\n" +
                "    \"avatar\": \"/avatar2.jpg\",\n" +
                "    \"status\": 1,\n" +
                "    \"telephone\": null,\n" +
                "    \"lastLoginIp\": \"27.154.74.117\",\n" +
                "    \"lastLoginTime\": 1534837621348,\n" +
                "    \"creatorId\": \"admin\",\n" +
                "    \"createTime\": 1497160610259,\n" +
                "    \"merchantCode\": \"TLif2btpzg079h15bk\",\n" +
                "    \"deleted\": 0,\n" +
                "    \"roleId\": \"admin\",\n" +
                "    \"role\": {}\n" +
                "  }";
        JSONObject userInfo = JSONObject.parseObject(userInfoStr);
        String roleObjStr = "{\n" +
                "    \"id\": \"admin\",\n" +
                "    \"name\": \"管理员\",\n" +
                "    \"describe\": \"拥有所有权限\",\n" +
                "    \"status\": 1,\n" +
                "    \"creatorId\": \"system\",\n" +
                "    \"createTime\": 1497160610259,\n" +
                "    \"deleted\": 0,\n" +
                "    \"permissions\": [{\n" +
                "      \"roleId\": \"admin\",\n" +
                "      \"permissionId\": \"dashboard\",\n" +
                "      \"permissionName\": \"仪表盘\",\n" +
                "      \"actions\": [{\"action\":\"add\",\"defaultCheck\":false,\"describe\":\"新增\"},{\"action\":\"query\",\"defaultCheck\":false,\"describe\":\"查询\"},{\"action\":\"get\",\"defaultCheck\":false,\"describe\":\"详情\"},{\"action\":\"update\",\"defaultCheck\":false,\"describe\":\"修改\"},{\"action\":\"delete\",\"defaultCheck\":false,\"describe\":\"删除\"}],\n" +
                "      \"actionEntitySet\": [{\n" +
                "        \"action\": \"add\",\n" +
                "        \"describe\": \"新增\",\n" +
                "        \"defaultCheck\": false\n" +
                "      }, {\n" +
                "        \"action\": \"query\",\n" +
                "        \"describe\": \"查询\",\n" +
                "        \"defaultCheck\": false\n" +
                "      }, {\n" +
                "        \"action\": \"get\",\n" +
                "        \"describe\": \"详情\",\n" +
                "        \"defaultCheck\": false\n" +
                "      }, {\n" +
                "        \"action\": \"update\",\n" +
                "        \"describe\": \"修改\",\n" +
                "        \"defaultCheck\": false\n" +
                "      }, {\n" +
                "        \"action\": \"delete\",\n" +
                "        \"describe\": \"删除\",\n" +
                "        \"defaultCheck\": false\n" +
                "      }],\n" +
                "      \"actionList\": null,\n" +
                "      \"dataAccess\": null\n" +
                "    }, {\n" +
                "      \"roleId\": \"admin\",\n" +
                "      \"permissionId\": \"exception\",\n" +
                "      \"permissionName\": \"异常页面权限\",\n" +
                "      \"actions\": [{\"action\":\"add\",\"defaultCheck\":false,\"describe\":\"新增\"},{\"action\":\"query\",\"defaultCheck\":false,\"describe\":\"查询\"},{\"action\":\"get\",\"defaultCheck\":false,\"describe\":\"详情\"},{\"action\":\"update\",\"defaultCheck\":false,\"describe\":\"修改\"},{\"action\":\"delete\",\"defaultCheck\":false,\"describe\":\"删除\"}],\n" +
                "      \"actionEntitySet\": [{\n" +
                "        \"action\": \"add\",\n" +
                "        \"describe\": \"新增\",\n" +
                "        \"defaultCheck\": false\n" +
                "      }, {\n" +
                "        \"action\": \"query\",\n" +
                "        \"describe\": \"查询\",\n" +
                "        \"defaultCheck\": false\n" +
                "      }, {\n" +
                "        \"action\": \"get\",\n" +
                "        \"describe\": \"详情\",\n" +
                "        \"defaultCheck\": false\n" +
                "      }, {\n" +
                "        \"action\": \"update\",\n" +
                "        \"describe\": \"修改\",\n" +
                "        \"defaultCheck\": false\n" +
                "      }, {\n" +
                "        \"action\": \"delete\",\n" +
                "        \"describe\": \"删除\",\n" +
                "        \"defaultCheck\": false\n" +
                "      }],\n" +
                "      \"actionList\": null,\n" +
                "      \"dataAccess\": null\n" +
                "    }, {\n" +
                "      \"roleId\": \"admin\",\n" +
                "      \"permissionId\": \"result\",\n" +
                "      \"permissionName\": \"结果权限\",\n" +
                "      \"actions\": [{\"action\":\"add\",\"defaultCheck\":false,\"describe\":\"新增\"},{\"action\":\"query\",\"defaultCheck\":false,\"describe\":\"查询\"},{\"action\":\"get\",\"defaultCheck\":false,\"describe\":\"详情\"},{\"action\":\"update\",\"defaultCheck\":false,\"describe\":\"修改\"},{\"action\":\"delete\",\"defaultCheck\":false,\"describe\":\"删除\"}],\n" +
                "      \"actionEntitySet\": [{\n" +
                "        \"action\": \"add\",\n" +
                "        \"describe\": \"新增\",\n" +
                "        \"defaultCheck\": false\n" +
                "      }, {\n" +
                "        \"action\": \"query\",\n" +
                "        \"describe\": \"查询\",\n" +
                "        \"defaultCheck\": false\n" +
                "      }, {\n" +
                "        \"action\": \"get\",\n" +
                "        \"describe\": \"详情\",\n" +
                "        \"defaultCheck\": false\n" +
                "      }, {\n" +
                "        \"action\": \"update\",\n" +
                "        \"describe\": \"修改\",\n" +
                "        \"defaultCheck\": false\n" +
                "      }, {\n" +
                "        \"action\": \"delete\",\n" +
                "        \"describe\": \"删除\",\n" +
                "        \"defaultCheck\": false\n" +
                "      }],\n" +
                "      \"actionList\": null,\n" +
                "      \"dataAccess\": null\n" +
                "    }, {\n" +
                "      \"roleId\": \"admin\",\n" +
                "      \"permissionId\": \"profile\",\n" +
                "      \"permissionName\": \"详细页权限\",\n" +
                "      \"actions\": [{\"action\":\"add\",\"defaultCheck\":false,\"describe\":\"新增\"},{\"action\":\"query\",\"defaultCheck\":false,\"describe\":\"查询\"},{\"action\":\"get\",\"defaultCheck\":false,\"describe\":\"详情\"},{\"action\":\"update\",\"defaultCheck\":false,\"describe\":\"修改\"},{\"action\":\"delete\",\"defaultCheck\":false,\"describe\":\"删除\"}],\n" +
                "      \"actionEntitySet\": [{\n" +
                "        \"action\": \"add\",\n" +
                "        \"describe\": \"新增\",\n" +
                "        \"defaultCheck\": false\n" +
                "      }, {\n" +
                "        \"action\": \"query\",\n" +
                "        \"describe\": \"查询\",\n" +
                "        \"defaultCheck\": false\n" +
                "      }, {\n" +
                "        \"action\": \"get\",\n" +
                "        \"describe\": \"详情\",\n" +
                "        \"defaultCheck\": false\n" +
                "      }, {\n" +
                "        \"action\": \"update\",\n" +
                "        \"describe\": \"修改\",\n" +
                "        \"defaultCheck\": false\n" +
                "      }, {\n" +
                "        \"action\": \"delete\",\n" +
                "        \"describe\": \"删除\",\n" +
                "        \"defaultCheck\": false\n" +
                "      }],\n" +
                "      \"actionList\": null,\n" +
                "      \"dataAccess\": null\n" +
                "    }, {\n" +
                "      \"roleId\": \"admin\",\n" +
                "      \"permissionId\": \"table\",\n" +
                "      \"permissionName\": \"表格权限\",\n" +
                "      \"actions\": [{\"action\":\"add\",\"defaultCheck\":false,\"describe\":\"新增\"},{\"action\":\"import\",\"defaultCheck\":false,\"describe\":\"导入\"},{\"action\":\"get\",\"defaultCheck\":false,\"describe\":\"详情\"},{\"action\":\"update\",\"defaultCheck\":false,\"describe\":\"修改\"}],\n" +
                "      \"actionEntitySet\": [{\n" +
                "        \"action\": \"add\",\n" +
                "        \"describe\": \"新增\",\n" +
                "        \"defaultCheck\": false\n" +
                "      }, {\n" +
                "        \"action\": \"import\",\n" +
                "        \"describe\": \"导入\",\n" +
                "        \"defaultCheck\": false\n" +
                "      }, {\n" +
                "        \"action\": \"get\",\n" +
                "        \"describe\": \"详情\",\n" +
                "        \"defaultCheck\": false\n" +
                "      }, {\n" +
                "        \"action\": \"update\",\n" +
                "        \"describe\": \"修改\",\n" +
                "        \"defaultCheck\": false\n" +
                "      }],\n" +
                "      \"actionList\": null,\n" +
                "      \"dataAccess\": null\n" +
                "    }, {\n" +
                "      \"roleId\": \"admin\",\n" +
                "      \"permissionId\": \"form\",\n" +
                "      \"permissionName\": \"表单权限\",\n" +
                "      \"actions\": [{\"action\":\"add\",\"defaultCheck\":false,\"describe\":\"新增\"},{\"action\":\"get\",\"defaultCheck\":false,\"describe\":\"详情\"},{\"action\":\"query\",\"defaultCheck\":false,\"describe\":\"查询\"},{\"action\":\"update\",\"defaultCheck\":false,\"describe\":\"修改\"},{\"action\":\"delete\",\"defaultCheck\":false,\"describe\":\"删除\"}],\n" +
                "      \"actionEntitySet\": [{\n" +
                "        \"action\": \"add\",\n" +
                "        \"describe\": \"新增\",\n" +
                "        \"defaultCheck\": false\n" +
                "      }, {\n" +
                "        \"action\": \"get\",\n" +
                "        \"describe\": \"详情\",\n" +
                "        \"defaultCheck\": false\n" +
                "      }, {\n" +
                "        \"action\": \"query\",\n" +
                "        \"describe\": \"查询\",\n" +
                "        \"defaultCheck\": false\n" +
                "      }, {\n" +
                "        \"action\": \"update\",\n" +
                "        \"describe\": \"修改\",\n" +
                "        \"defaultCheck\": false\n" +
                "      }, {\n" +
                "        \"action\": \"delete\",\n" +
                "        \"describe\": \"删除\",\n" +
                "        \"defaultCheck\": false\n" +
                "      }],\n" +
                "      \"actionList\": null,\n" +
                "      \"dataAccess\": null\n" +
                "    }, {\n" +
                "      \"roleId\": \"admin\",\n" +
                "      \"permissionId\": \"order\",\n" +
                "      \"permissionName\": \"订单管理\",\n" +
                "      \"actions\": [{\"action\":\"add\",\"defaultCheck\":false,\"describe\":\"新增\"},{\"action\":\"query\",\"defaultCheck\":false,\"describe\":\"查询\"},{\"action\":\"get\",\"defaultCheck\":false,\"describe\":\"详情\"},{\"action\":\"update\",\"defaultCheck\":false,\"describe\":\"修改\"},{\"action\":\"delete\",\"defaultCheck\":false,\"describe\":\"删除\"}],\n" +
                "      \"actionEntitySet\": [{\n" +
                "        \"action\": \"add\",\n" +
                "        \"describe\": \"新增\",\n" +
                "        \"defaultCheck\": false\n" +
                "      }, {\n" +
                "        \"action\": \"query\",\n" +
                "        \"describe\": \"查询\",\n" +
                "        \"defaultCheck\": false\n" +
                "      }, {\n" +
                "        \"action\": \"get\",\n" +
                "        \"describe\": \"详情\",\n" +
                "        \"defaultCheck\": false\n" +
                "      }, {\n" +
                "        \"action\": \"update\",\n" +
                "        \"describe\": \"修改\",\n" +
                "        \"defaultCheck\": false\n" +
                "      }, {\n" +
                "        \"action\": \"delete\",\n" +
                "        \"describe\": \"删除\",\n" +
                "        \"defaultCheck\": false\n" +
                "      }],\n" +
                "      \"actionList\": null,\n" +
                "      \"dataAccess\": null\n" +
                "    }, {\n" +
                "      \"roleId\": \"admin\",\n" +
                "      \"permissionId\": \"permission\",\n" +
                "      \"permissionName\": \"权限管理\",\n" +
                "      \"actions\": [{\"action\":\"add\",\"defaultCheck\":false,\"describe\":\"新增\"},{\"action\":\"get\",\"defaultCheck\":false,\"describe\":\"详情\"},{\"action\":\"update\",\"defaultCheck\":false,\"describe\":\"修改\"},{\"action\":\"delete\",\"defaultCheck\":false,\"describe\":\"删除\"}],\n" +
                "      \"actionEntitySet\": [{\n" +
                "        \"action\": \"add\",\n" +
                "        \"describe\": \"新增\",\n" +
                "        \"defaultCheck\": false\n" +
                "      }, {\n" +
                "        \"action\": \"get\",\n" +
                "        \"describe\": \"详情\",\n" +
                "        \"defaultCheck\": false\n" +
                "      }, {\n" +
                "        \"action\": \"update\",\n" +
                "        \"describe\": \"修改\",\n" +
                "        \"defaultCheck\": false\n" +
                "      }, {\n" +
                "        \"action\": \"delete\",\n" +
                "        \"describe\": \"删除\",\n" +
                "        \"defaultCheck\": false\n" +
                "      }],\n" +
                "      \"actionList\": null,\n" +
                "      \"dataAccess\": null\n" +
                "    }, {\n" +
                "      \"roleId\": \"admin\",\n" +
                "      \"permissionId\": \"role\",\n" +
                "      \"permissionName\": \"角色管理\",\n" +
                "      \"actions\": [{\"action\":\"add\",\"defaultCheck\":false,\"describe\":\"新增\"},{\"action\":\"get\",\"defaultCheck\":false,\"describe\":\"详情\"},{\"action\":\"update\",\"defaultCheck\":false,\"describe\":\"修改\"},{\"action\":\"delete\",\"defaultCheck\":false,\"describe\":\"删除\"}],\n" +
                "      \"actionEntitySet\": [{\n" +
                "        \"action\": \"add\",\n" +
                "        \"describe\": \"新增\",\n" +
                "        \"defaultCheck\": false\n" +
                "      }, {\n" +
                "        \"action\": \"get\",\n" +
                "        \"describe\": \"详情\",\n" +
                "        \"defaultCheck\": false\n" +
                "      }, {\n" +
                "        \"action\": \"update\",\n" +
                "        \"describe\": \"修改\",\n" +
                "        \"defaultCheck\": false\n" +
                "      }, {\n" +
                "        \"action\": \"delete\",\n" +
                "        \"describe\": \"删除\",\n" +
                "        \"defaultCheck\": false\n" +
                "      }],\n" +
                "      \"actionList\": null,\n" +
                "      \"dataAccess\": null\n" +
                "    }, {\n" +
                "      \"roleId\": \"admin\",\n" +
                "      \"permissionId\": \"table\",\n" +
                "      \"permissionName\": \"桌子管理\",\n" +
                "      \"actions\": [{\"action\":\"add\",\"defaultCheck\":false,\"describe\":\"新增\"},{\"action\":\"get\",\"defaultCheck\":false,\"describe\":\"详情\"},{\"action\":\"query\",\"defaultCheck\":false,\"describe\":\"查询\"},{\"action\":\"update\",\"defaultCheck\":false,\"describe\":\"修改\"},{\"action\":\"delete\",\"defaultCheck\":false,\"describe\":\"删除\"}],\n" +
                "      \"actionEntitySet\": [{\n" +
                "        \"action\": \"add\",\n" +
                "        \"describe\": \"新增\",\n" +
                "        \"defaultCheck\": false\n" +
                "      }, {\n" +
                "        \"action\": \"get\",\n" +
                "        \"describe\": \"详情\",\n" +
                "        \"defaultCheck\": false\n" +
                "      }, {\n" +
                "        \"action\": \"query\",\n" +
                "        \"describe\": \"查询\",\n" +
                "        \"defaultCheck\": false\n" +
                "      }, {\n" +
                "        \"action\": \"update\",\n" +
                "        \"describe\": \"修改\",\n" +
                "        \"defaultCheck\": false\n" +
                "      }, {\n" +
                "        \"action\": \"delete\",\n" +
                "        \"describe\": \"删除\",\n" +
                "        \"defaultCheck\": false\n" +
                "      }],\n" +
                "      \"actionList\": null,\n" +
                "      \"dataAccess\": null\n" +
                "    }, {\n" +
                "      \"roleId\": \"admin\",\n" +
                "      \"permissionId\": \"user\",\n" +
                "      \"permissionName\": \"用户管理\",\n" +
                "      \"actions\": [{\"action\":\"add\",\"defaultCheck\":false,\"describe\":\"新增\"},{\"action\":\"import\",\"defaultCheck\":false,\"describe\":\"导入\"},{\"action\":\"get\",\"defaultCheck\":false,\"describe\":\"详情\"},{\"action\":\"update\",\"defaultCheck\":false,\"describe\":\"修改\"},{\"action\":\"delete\",\"defaultCheck\":false,\"describe\":\"删除\"},{\"action\":\"export\",\"defaultCheck\":false,\"describe\":\"导出\"}],\n" +
                "      \"actionEntitySet\": [{\n" +
                "        \"action\": \"add\",\n" +
                "        \"describe\": \"新增\",\n" +
                "        \"defaultCheck\": false\n" +
                "      }, {\n" +
                "        \"action\": \"import\",\n" +
                "        \"describe\": \"导入\",\n" +
                "        \"defaultCheck\": false\n" +
                "      }, {\n" +
                "        \"action\": \"get\",\n" +
                "        \"describe\": \"详情\",\n" +
                "        \"defaultCheck\": false\n" +
                "      }, {\n" +
                "        \"action\": \"update\",\n" +
                "        \"describe\": \"修改\",\n" +
                "        \"defaultCheck\": false\n" +
                "      }, {\n" +
                "        \"action\": \"delete\",\n" +
                "        \"describe\": \"删除\",\n" +
                "        \"defaultCheck\": false\n" +
                "      }, {\n" +
                "        \"action\": \"export\",\n" +
                "        \"describe\": \"导出\",\n" +
                "        \"defaultCheck\": false\n" +
                "      }],\n" +
                "      \"actionList\": null,\n" +
                "      \"dataAccess\": null\n" +
                "    }, {\n" +
                "      \"roleId\": \"admin\",\n" +
                "      \"permissionId\": \"support\",\n" +
                "      \"permissionName\": \"超级模块\",\n" +
                "      \"actions\": [{\"action\":\"add\",\"defaultCheck\":false,\"describe\":\"新增\"},{\"action\":\"import\",\"defaultCheck\":false,\"describe\":\"导入\"},{\"action\":\"get\",\"defaultCheck\":false,\"describe\":\"详情\"},{\"action\":\"update\",\"defaultCheck\":false,\"describe\":\"修改\"},{\"action\":\"delete\",\"defaultCheck\":false,\"describe\":\"删除\"},{\"action\":\"export\",\"defaultCheck\":false,\"describe\":\"导出\"}],\n" +
                "      \"actionEntitySet\": [{\n" +
                "        \"action\": \"add\",\n" +
                "        \"describe\": \"新增\",\n" +
                "        \"defaultCheck\": false\n" +
                "      }, {\n" +
                "        \"action\": \"import\",\n" +
                "        \"describe\": \"导入\",\n" +
                "        \"defaultCheck\": false\n" +
                "      }, {\n" +
                "        \"action\": \"get\",\n" +
                "        \"describe\": \"详情\",\n" +
                "        \"defaultCheck\": false\n" +
                "      }, {\n" +
                "        \"action\": \"update\",\n" +
                "        \"describe\": \"修改\",\n" +
                "        \"defaultCheck\": false\n" +
                "      }, {\n" +
                "        \"action\": \"delete\",\n" +
                "        \"describe\": \"删除\",\n" +
                "        \"defaultCheck\": false\n" +
                "      }, {\n" +
                "        \"action\": \"export\",\n" +
                "        \"describe\": \"导出\",\n" +
                "        \"defaultCheck\": false\n" +
                "      }],\n" +
                "      \"actionList\": null,\n" +
                "      \"dataAccess\": null\n" +
                "    }]\n" +
                "  }";
        JSONObject roleObj = JSONObject.parseObject(roleObjStr);
        userInfo.put("role", roleObj);
        JSONObject result = new JSONObject();
        result.put("result", userInfo);
        return result;
    }
}
