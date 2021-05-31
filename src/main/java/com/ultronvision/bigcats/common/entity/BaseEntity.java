package com.ultronvision.bigcats.common.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @author oldwei
 * @date 2021/5/31 2:50 下午
 */
@Data
public class BaseEntity implements Serializable {
    private static final long serialVersionUID = 3444128537672495830L;
    /**
     * 主键ID
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    protected Long id;

    /**
     * 删除标记 0:正常，1-删除
     * 数据库设置默认值0(推荐)
     */
    @TableLogic
    protected Integer delFlag = 0;

    /**
     * 部门ID
     */
    protected Long deptId;

    /**
     * 查询开始时间
     */
    @TableField(exist = false)
    private String createTimeFrom;
    /**
     * 查询结束时间
     */
    @TableField(exist = false)
    private String createTimeTo;
    /**
     * 当前页面数据量
     */
    @TableField(exist = false)
    private int pageSize = 10;
    /**
     * 当前页码
     */
    @TableField(exist = false)
    private int pageIndex = 1;
}
