package com.ultronvision.bigcats.modules.check.entity.po;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户与项目权限
 * @author oldwei
 * @date 2021-12-15 15:08
 */
@Data
public class UserProjectPermissionPO implements Serializable {
    private static final long serialVersionUID = -2685963487785882384L;
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
     * 项目ID
     */
    private Long projectId;
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
