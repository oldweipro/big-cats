package com.ultronvision.bigcats.modules.check.entity.po;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * 班次表：设置班次基本信息
 *
 * @author oldwei
 * @date 2021-12-15 13:29
 */
@Data
public class WorkShiftPO implements Serializable {
    private static final long serialVersionUID = 1443915334012314018L;
    /**
     * 主键ID
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    @TableId
    private Long id;

    /**
     * 班次名称
     */
    private String workShiftName;
    /**
     * 工作类型:按天（默认）、按周、按月
     */
    private Integer workType;
    /**
     * 打卡地点：可添加多个打卡地点
     */
    private String checkLocation;
    /**
     * 打卡方式：定位、人脸；验证所购选项，不勾选，则考勤组成员打卡则不限制
     */
    private String checkType;
    /**
     * 多少个小时为一个班，需要设置每一个班的时长
     */
    private Double hoursOfWorkShift;
    /**
     * 每天几点开始新的考勤周期
     */
    private String newCycle;
    /**
     * 班次标识
     */
    private String workShiftSign;
    /**
     * 班次工资
     */
    private BigDecimal workShiftSalary;
    /**
     * 删除标记 0:正常，1-删除
     * 数据库设置默认值0(推荐)
     */
    @TableLogic
    private Integer delFlag = 0;
}
