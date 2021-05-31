package com.ultronvision.bigcats.common.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * @author oldwei
 * @date 2021/5/31 2:50 下午
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class SysUserToken extends BaseEntity {
    private static final long serialVersionUID = 6437595997000118274L;
    /**
     * 用户ID
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long userId;

    /**
     * token
     */
    private String token;

    /**
     * 过期时间
     */
    private Date expireTime;

    /**
     * 更新时间
     */
    private Date updateTime;
}
