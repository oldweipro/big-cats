package com.ultronvision.bigcats.common.entity.cats;

import com.ultronvision.bigcats.common.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 系统用户
 *
 * @author oldwei
 * @date 2021/5/31 2:53 下午
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class SysUser extends BaseEntity {
    private static final long serialVersionUID = -5948243617895325309L;
    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 盐
     */
    private String salt;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 状态  0：禁用   1：正常
     */
    private Integer status = 1;
}
