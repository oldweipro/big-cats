package com.ultronvision.bigcats.common.entity.hik;

import com.baomidou.mybatisplus.annotation.TableField;
import com.fasterxml.jackson.annotation.JsonFormat;
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
public class Device extends BaseEntity implements Serializable {
    private static final long serialVersionUID = -214941278617300948L;
    private String ip;
    private String username;
    private String password;
    private Short port = 8000;
    private String title;
    @TableField(exist = false)
    private String loginStatus;
    @TableField(exist = false)
    private String pushStatus;
    @TableField(exist = false)
    private String alarmStatus;
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private Long categoryId;
    private String flv;
    private String hls;
    private String rtmp;
    private Boolean useAsync = false;
    private Byte type;
    private String rtspUrl;
    private String pushUrl;
    private String deviceSn;
}
