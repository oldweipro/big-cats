package com.ultronvision.bigcats.modules.cats.entity.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.io.Serializable;

/**
 * @author oldwei
 * @date 2021-6-8 16:48
 */
@Data
public class QueryRequest implements Serializable {

    private static final long serialVersionUID = -100317122549940530L;
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
    private int pageNo = 1;
}
