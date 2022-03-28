package com.ultronvision.bigcats.modules.check.enumeration;

/**
 * 性别枚举
 *
 * @author oldwei
 * @date 2021-12-15 14:00
 */
public enum GenderEnum {
    /**
     * 女性
     */
    FEMALE("女性"),
    /**
     * 男性
     */
    MALE("男性"),
    /**
     * 未知
     */
    UNKNOWN("未知");

    /**
     * 性别别称
     */
    private final String name;

    /**
     * 性别枚举
     *
     * @param name 性别别称
     */
    GenderEnum(String name) {
        this.name = name;
    }

    /**
     * 获取性别名称
     *
     * @return 性别名称
     */
    public String getName() {
        return name;
    }
}
