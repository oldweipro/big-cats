package com.ultronvision.bigcats.modules.check.enumeration;

/**
 * 项目服务类型
 *
 * @author oldwei
 * @date 2021-12-15 14:27
 */
public enum ProjectServiceCategoryEnum {
    /**
     * 项目服务类型：物业、工程、商场、活动、赛事、博物馆、医院、交通、工厂、治安巡逻、娱乐场所、政府单位、图书馆、保镖、危机、押运、技防
     */
    PROPERTY("物业"),
    ENGINEERING("工程"),
    MALL("商场"),
    ACTIVITY("活动"),
    MATCH("赛事"),
    MUSEUM("博物馆"),
    HOSPITAL("医院"),
    TRANSPORTATION("交通"),
    FACTORY("工厂"),
    SECURITY_PATROL("治安巡逻"),
    ENTERTAINMENT_VENUES("娱乐场所"),
    GOVERNMENT("政府单位"),
    LIBRARY("图书馆"),
    BODYGUARD("保镖"),
    CRISIS("危机"),
    ESCORT("押运"),
    TECHNICAL_DEFENSE("技防");

    private final String name;

    ProjectServiceCategoryEnum(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
