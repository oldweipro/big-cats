package com.ultronvision.bigcats.common.entity.cats;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ultronvision.bigcats.common.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author oldwei
 * @date 2021/5/31 4:46 下午
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class SysLog extends BaseEntity {
    private static final long serialVersionUID = 7061209970791735663L;
    /**
     * 用户名
     */
    private String username;
    /**
     * 用户操作
     */
    private String operation;
    /**
     * 请求方法
     */
    private String method;
    /**
     * 请求参数
     */
    private String params;
    /**
     * 执行时长(毫秒)
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long time;
    /**
     * IP地址
     */
    private String ip;
    /**
     * 创建者ID
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long creatorId;
    /**
     * 修改者ID
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long modifierId;

}
