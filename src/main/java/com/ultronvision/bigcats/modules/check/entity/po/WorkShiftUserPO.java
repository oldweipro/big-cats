package com.ultronvision.bigcats.modules.check.entity.po;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;

/**
 * 考勤组：班次和用户关联表，一个班次对多个考勤人员，一个考勤人员对？个班次。
 *
 * @author oldwei
 * @date 2021-12-15 13:30
 */
@Data
public class WorkShiftUserPO implements Serializable {
    private static final long serialVersionUID = -5159591056866369930L;
    /**
     * 主键ID
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    @TableId
    private Long id;

    /**
     * 班次ID
     */
    private Long workShiftId;
    /**
     * 用户ID
     */
    private Long userId;
    /**
     * 删除标记 0:正常，1-删除
     * 数据库设置默认值0(推荐)
     */
    @TableLogic
    private Integer delFlag = 0;
}
