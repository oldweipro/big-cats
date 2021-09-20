package com.ultronvision.bigcats.common.entity.hik;

import com.ultronvision.bigcats.common.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * @author oldwei
 * @date 2021-8-2 09:54
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class Category extends BaseEntity implements Serializable {
    private static final long serialVersionUID = -7180738356391754189L;
    private String title;
}
