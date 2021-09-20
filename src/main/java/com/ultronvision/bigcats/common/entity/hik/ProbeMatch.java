package com.ultronvision.bigcats.common.entity.hik;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * 设备搜索返回的字段（可能有缺失）
 *
 * @author oldwei
 * @date 2021-9-16 14:58
 */
@Data
public class ProbeMatch implements Serializable {
    private static final long serialVersionUID = 3696151581175207417L;

    @TableId(value = "device_sn", type = IdType.INPUT)
    private String DeviceSN;

    @TableField("uuid")
    private String Uuid;

    @TableField("types")
    private String Types;

    @TableField("device_type")
    private String DeviceType;

    @TableField("device_description")
    private String DeviceDescription;

    @TableField("command_port")
    private String CommandPort;

    @TableField("http_port")
    private String HttpPort;

    @TableField("mac")
    private String MAC;

    @TableField("ipv4_address")
    private String IPv4Address;

    @TableField("ipv4_subnet_mask")
    private String IPv4SubnetMask;

    @TableField("ipv4_gateway")
    private String IPv4Gateway;

    @TableField("ipv6_address")
    private String IPv6Address;

    @TableField("ipv6_gateway")
    private String IPv6Gateway;

    @TableField("ipv6_maskLen")
    private String IPv6MaskLen;

    @TableField("dhcp")
    private String DHCP;

    @TableField("analog_channel_num")
    private String AnalogChannelNum;

    @TableField("digital_channel_num")
    private String DigitalChannelNum;

    @TableField("software_version")
    private String SoftwareVersion;

    @TableField("dsp_version")
    private String DSPVersion;

    @TableField("boot_time")
    private String BootTime;

    @TableField("encrypt")
    private String Encrypt;

    @TableField("reset_ability")
    private String ResetAbility;

    @TableField("disk_number")
    private String DiskNumber;

    @TableField("activated")
    private String Activated;

    @TableField("password_reset_ability")
    private String PasswordResetAbility;

    @TableField("password_reset_mode_second")
    private String PasswordResetModeSecond;

    @TableField("support_security_question")
    private String SupportSecurityQuestion;

    @TableField("support_hc_platform")
    private String SupportHCPlatform;

    @TableField("hc_platform_enable")
    private String HCPlatformEnable;

    @TableField("is_modify_verification_code")
    private String IsModifyVerificationCode;

    @TableField("salt")
    private String Salt;

    @TableField("device_lock")
    private String DeviceLock;

    @TableField("support_mail_box")
    private String SupportMailBox;

    @TableField("support_ezviz_unbind")
    private String supportEzvizUnbind;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    @TableField("project_id")
    private Long projectId;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    @TableField("category_id")
    private Long categoryId;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    @TableField("tenant_id")
    private Long tenantId;
    /**
     * 更新日期
     */
    @TableField("modify_time")
    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    protected Date modifyTime;
}
