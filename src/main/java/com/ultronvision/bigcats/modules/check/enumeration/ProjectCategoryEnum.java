package com.ultronvision.bigcats.modules.check.enumeration;

/**
 * 项目类型：长保、临保
 *
 * @author oldwei
 * @date 2021-12-15 14:20
 */
public enum ProjectCategoryEnum {
    /**
     * 长保
     */
    LONG_PROTECT("长保"),
    /**
     * 临保
     */
    TEMPORARY_PROTECT("临保");

    private final String name;

    ProjectCategoryEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
