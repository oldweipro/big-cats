package com.ultronvision.bigcats.common.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @author oldwei
 * @date 2021/5/31 2:50 下午
 */
@Data
public class BaseEntity implements Serializable {
    private static final long serialVersionUID = 3444128537672495830L;
    /**
     * 主键ID
     */
    @JsonFormat(shape = JsonFormat.Shape.STRING)
    protected Long id;
}
