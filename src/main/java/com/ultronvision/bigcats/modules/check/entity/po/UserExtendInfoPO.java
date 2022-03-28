package com.ultronvision.bigcats.modules.check.entity.po;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;

/**
 * 用户扩展基本信息:保安证、身份证等信息、一对一关系
 * 在用户表存储此表的一对一关系，此表不存在user_id
 * @author oldwei
 * @date 2021-12-15 13:28
 */
@Data
public class UserExtendInfoPO implements Serializable {
    private static final long serialVersionUID = -5130885639063008283L;
    /**
     * 主键ID
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    @TableId
    private Long id;
    /**
     * 身份证号
     */
    private String idCardNum;
    /**
     * 身份证正面照片
     */
    private String idCardFrontPhoto;
    /**
     * 身份证反面照片
     */
    private String idCardReversePhoto;
    /**
     * 保安证号
     */
    private String securityGuardLicence;
    /**
     * 保安证照片
     */
    private String securityGuardLicencePhoto;
    /**
     * 创建时间，记录时间，方便做定期删除无用的数据
     */
    private String createTime;

    /**
     * 删除标记 0:正常，1-删除
     * 数据库设置默认值0(推荐)
     */
    @TableLogic
    private Integer delFlag = 0;
}
