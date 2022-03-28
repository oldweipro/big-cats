package com.ultronvision.bigcats.modules.check.entity.po;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户部门权限
 * @author oldwei
 * @date 2021-12-15 13:28
 */
@Data
public class UserDeptPermissionPO implements Serializable {
    private static final long serialVersionUID = 2396023974704731785L;
    /**
     * 主键ID
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    @TableId
    private Long id;
    /**
     * 用户ID
     */
    private Long userId;
    /**
     * 部门ID
     */
    private Long deptId;
    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 删除标记 0:正常，1-删除
     * 数据库设置默认值0(推荐)
     */
    @TableLogic
    private Integer delFlag = 0;
}
