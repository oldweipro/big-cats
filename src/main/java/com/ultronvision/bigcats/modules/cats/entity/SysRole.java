package com.ultronvision.bigcats.modules.cats.entity;

import com.ultronvision.bigcats.modules.cats.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author oldwei
 * @date 2021/5/31 4:50 下午
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class SysRole extends BaseEntity {

    private static final long serialVersionUID = 5436374021040266478L;
    /**
     * 角色名称
     */
    private String roleName;

    /**
     * 备注
     */
    private String remark;
}
