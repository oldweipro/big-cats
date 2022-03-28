package com.ultronvision.bigcats.modules.check.entity.po;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 打卡时间
 *
 * @author oldwei
 * @date 2021-12-15 13:29
 */
@Data
public class WorkShiftCheckWorkTimePO implements Serializable {
    private static final long serialVersionUID = -5524415366978066950L;
    /**
     * 主键ID
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    @TableId
    private Long id;

    /**
     * 上班时间
     */
    private Date startWorkTime;
    /**
     * 下班时间
     */
    private Date endWorkTime;
    /**
     * 打卡时间范围区间
     */
    private Integer checkRange;
    /**
     * 班次ID
     */
    private Long workShiftId;

    /**
     * 删除标记 0:正常，1-删除
     * 数据库设置默认值0(推荐)
     */
    @TableLogic
    private Integer delFlag = 0;
}
