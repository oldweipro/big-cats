package com.ultronvision.bigcats.modules.cats.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.ultronvision.bigcats.modules.cats.entity.QueryRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * 系统用户
 *
 * @author oldwei
 * @date 2021/5/31 2:53 下午
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class SysUser extends QueryRequest {
    private static final long serialVersionUID = -5948243617895325309L;
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
