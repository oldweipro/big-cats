package com.ultronvision.bigcats.common.entity.cats;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.ultronvision.bigcats.common.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author oldwei
 * @date 2021/5/31 4:44 下午
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class SysMenu extends BaseEntity {
    private static final long serialVersionUID = 8429974827114705475L;
    /**
     * 父级菜单ID，一级菜单为0
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long parentId;

    /**
     * 父级菜单名称
     */
    @TableField(exist = false)
    private String parentName;

    /**
     * 菜单名称
     */
    private String name;

    /**
     * 菜单URL
     */
    private String url;

    /**
     * 授权(多个逗号分隔，如：user:list,user:create)
     */
    private String perms;

    /**
     * 类型 0：目录 1：菜单 2：按钮
     */
    private Integer type;

    /**
     * 菜单图标
     */
    private String icon;

    /**
     * 排序
     */
    private Integer sortNum;
}
