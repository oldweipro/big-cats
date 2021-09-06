package com.ultronvision.bigcats.common.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author oldwei
 * @date 2021/5/31 2:50 下午
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class BaseEntity extends QueryRequest {
    private static final long serialVersionUID = 3444128537672495830L;
    /**
     * 主键ID
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    @TableId
    protected Long id;

    /**
     * 删除标记 0:正常，1-删除
     * 数据库设置默认值0(推荐)
     */
    @TableLogic
    protected Integer delFlag = 0;

    /**
     * 创建者
     */
    @TableField("creator")
    protected String creator;

    /**
     * 创建日期
     */
    @TableField("create_time")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    protected Date createTime;

    /**
     * 更新者
     */
    @TableField("modifier")
    protected String modifier;

    /**
     * 更新日期
     */
    @TableField("modify_time")
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    protected Date modifyTime;

    /**
     * 租户ID
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long tenantId;

    /**
     * 部门ID
     */
    protected Long deptId;

}
