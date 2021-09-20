package com.ultronvision.bigcats.common.entity.hik;

import com.ultronvision.bigcats.common.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author oldwei
 * @date 2021-9-16 15:29
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class Project extends BaseEntity {
    private static final long serialVersionUID = -7696160623643709852L;
    private String projectName;
}
