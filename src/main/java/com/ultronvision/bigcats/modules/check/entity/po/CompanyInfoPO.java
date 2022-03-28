package com.ultronvision.bigcats.modules.check.entity.po;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;

/**
 * 企业基本信息
 *
 * @author oldwei
 * @date 2021-12-15 13:27
 */
@Data
public class CompanyInfoPO implements Serializable {
    private static final long serialVersionUID = -1639506971133438211L;
    /**
     * 主键ID
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    @TableId
    private Long id;
    /**
     * 公司代码
     */
    private String companyCode;
    /**
     * 公司名称
     */
    private String companyName;
    /**
     * 公司logo
     */
    private String companyLogo;
    /**
     * 关联账号
     */
    private Long accountUserId;

    /**
     * 删除标记 0:正常，1-删除
     * 数据库设置默认值0(推荐)
     */
    @TableLogic
    private Integer delFlag = 0;
}
