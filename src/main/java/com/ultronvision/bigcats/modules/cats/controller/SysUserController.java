package com.ultronvision.bigcats.modules.cats.controller;

import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.ultronvision.bigcats.common.entity.BaseController;
import com.ultronvision.bigcats.common.entity.QueryRequest;
import com.ultronvision.bigcats.common.entity.cats.SysUser;
import com.ultronvision.bigcats.common.util.BigCatsUtil;
import com.ultronvision.bigcats.modules.cats.service.ISysUserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * 用户相关
 *
 * @author oldwei
 * @date 2021/6/1 4:52 下午
 */
@Slf4j
@RestController
@RequestMapping("sys/user")
@RequiredArgsConstructor
public class SysUserController extends BaseController {
    private final ISysUserService sysUserService;

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
        JSONObject userInfo = JSONUtil.parseObj(userInfoStr);
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
        JSONObject roleObj = JSONUtil.parseObj(roleObjStr);
        userInfo.set("role", roleObj);
        JSONObject result = new JSONObject();
        result.set("result", userInfo);
        return result;
    }

    /**
     * 查询用户信息列表
     *
     * @param request
     * @param sysUser
     * @return
     */
    @GetMapping
    public ResponseEntity<JSONObject> user(QueryRequest request, SysUser sysUser) {
        IPage<SysUser> sysUserPage = new Page<>(request.getPageNo(), request.getPageSize());
        // 创建条件构造器
        LambdaQueryWrapper<SysUser> lambdaQueryWrapper = new LambdaQueryWrapper<>();
        // 构造条件
        lambdaQueryWrapper.like(StrUtil.isNotBlank(sysUser.getUsername()), SysUser::getUsername, sysUser.getUsername())
                .ge(StrUtil.isNotBlank(request.getCreateTimeFrom()), SysUser::getCreateTime, request.getCreateTimeFrom())
                .le(StrUtil.isNotBlank(request.getCreateTimeTo()), SysUser::getCreateTime, request.getCreateTimeTo())
                .orderByDesc(SysUser::getCreateTime);
        Map<String, Object> dataTable = BigCatsUtil.getDataTable(this.sysUserService.page(sysUserPage, lambdaQueryWrapper));
        JSONObject result = new JSONObject();
        result.set("result", dataTable);
        return ResponseEntity.ok(result);
    }

    /**
     * 新增用户
     *
     * @param sysUser
     * @return
     */
    @PostMapping
    public ResponseEntity<JSONObject> addUser(SysUser sysUser) {
        if (StrUtil.isBlank(sysUser.getUsername())) {
            return ResponseEntity.badRequest().build();
        }
        // 检查username用户名重复
        boolean isDuplicate = this.sysUserService.checkUsernameDuplicate(sysUser.getUsername());
        if (isDuplicate) {
            return ResponseEntity.badRequest().build();
        }
        sysUser.setPassword(SecureUtil.md5(sysUser.getPassword()));
        // 构造条件
        boolean isSave = this.sysUserService.save(sysUser);
        JSONObject result = new JSONObject();
        result.set("result", isSave);
        return ResponseEntity.ok(result);
    }

    /**
     * 修改用户
     *
     * @param sysUser
     * @return
     */
    @PutMapping
    public ResponseEntity<JSONObject> modifyUser(SysUser sysUser) {
        if (null == sysUser.getId()) {
            return ResponseEntity.badRequest().build();
        }
        if (StrUtil.isNotBlank(sysUser.getPassword())) {
            sysUser.setPassword(SecureUtil.md5(sysUser.getPassword()));
        }
        // 构造条件
        boolean isSave = this.sysUserService.updateById(sysUser);
        JSONObject result = new JSONObject();
        result.set("result", isSave);
        return ResponseEntity.ok(result);
    }

    /**
     * 删除用户
     *
     * @param userIds 用户id列表
     * @return
     */
    @DeleteMapping("/{userIds}")
    public ResponseEntity<JSONObject> modifyUser(@PathVariable String userIds) {
        // 构造条件
        String[] ids = userIds.split(StringPool.COMMA);
        List<String> list = Arrays.asList(ids);
        boolean removeByIds = this.sysUserService.removeByIds(list);
        JSONObject result = new JSONObject();
        result.set("result", removeByIds);
        return ResponseEntity.ok(result);
    }
}
