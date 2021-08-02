package com.ultronvision.bigcats.common.entity.hik;

import com.ultronvision.bigcats.common.entity.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author oldwei
 * @date 2021-8-2 09:54
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class Device extends BaseEntity {
    private static final long serialVersionUID = -214941278617300948L;
    private String ip;
    private String username;
    private String password;
    private Integer port;
    private String title;
    private Long categoryId;
    private String flv;
    private String hls;
    private String rtmp;
}
