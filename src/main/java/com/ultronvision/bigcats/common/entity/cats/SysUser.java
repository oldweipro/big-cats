package com.ultronvision.bigcats.common.entity.cats;

import com.ultronvision.bigcats.common.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 系统用户
 *
 * @author oldwei
 * @date 2021/5/31 2:53 下午
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class SysUser extends BaseEntity implements Serializable {
    private static final long serialVersionUID = -5948243617895325309L;

    /**
     * 姓名
     */
    private String name;
    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password = "000000";

    /**
     * 头像
     */
    private String avatar;
    /**
     * 电话
     */
    private String telephone;
    /**
     * 最后一次登录的IP地址
     */
    private String lastLoginIp;
    /**
     * 最后一次登录的时间戳
     */
    private Long lastLoginTime;

    /**
     * 盐
     */
    private String salt;

    /**
     * 系统语言
     */
    private String lang;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 状态  0：禁用   1：正常
     */
    private Integer status = 1;
}
