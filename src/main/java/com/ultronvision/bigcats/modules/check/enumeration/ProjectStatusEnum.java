package com.ultronvision.bigcats.modules.check.enumeration;

/**
 * 项目状态：已签、在签、未签、过期、撤点
 *
 * @author oldwei
 * @date 2021-12-15 14:14
 */
public enum ProjectStatusEnum {
    /**
     * 已签
     */
    SIGNED("已签"),
    /**
     * 在签
     */
    SIGNING("在签"),
    /**
     * 未签
     */
    UNSIGNED("未签"),
    /**
     * 过期
     */
    EXPIRED("过期"),
    /**
     * 撤点
     */
    REVOKE("撤点");

    private final String name;

    ProjectStatusEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
