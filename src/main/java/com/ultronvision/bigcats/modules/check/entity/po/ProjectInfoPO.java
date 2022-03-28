package com.ultronvision.bigcats.modules.check.entity.po;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 项目基本信息
 *
 * @author oldwei
 * @date 2021-12-15 13:14
 */
@Data
public class ProjectInfoPO implements Serializable {
    private static final long serialVersionUID = 94580918452869703L;
    /**
     * 主键ID
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    @TableId
    private Long id;

    /**
     * 项目编号
     */
    private String projectCode;

    /**
     * 项目名称
     */
    private String projectName;

    /**
     * 项目人数
     */
    private Integer projectPeopleNum;

    /**
     * 项目类型：长保、临保
     */
    private Integer projectStatus;

    /**
     * 项目状态：已签、在签、未签、过期、撤点
     */
    private Integer projectCategory;

    /**
     * 项目服务类型：物业、工程、商场、活动、赛事、博物馆、医院、交通、工厂、治安巡逻、娱乐场所、政府单位、图书馆、保镖、危机、押运、技防
     */
    private Integer projectServiceCategory;
    /**
     * 项目队长用户ID
     */
    private Long projectCaptainUserId;
    /**
     * 项目队长手机号
     */
    private Integer projectCaptainPhone;
    /**
     * 项目所属部门ID
     */
    private Long projectDeptId;
    /**
     * 项目合同周期：开始
     */
    private Date projectStartDate;
    /**
     * 项目合同周期：结束
     */
    private Date projectEndDate;

    /**
     * 删除标记 0:正常，1-删除
     * 数据库设置默认值0(推荐)
     */
    @TableLogic
    private Integer delFlag = 0;
}
