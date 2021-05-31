package com.ultronvision.bigcats.common.entity.cats;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ultronvision.bigcats.common.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author oldwei
 * @date 2021/5/31 4:52 下午
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class SysRoleMenu extends BaseEntity {
    private static final long serialVersionUID = -3604702993120128248L;
    /**
     * 角色ID
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long roleId;

    /**
     * 菜单ID
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long menuId;
}
