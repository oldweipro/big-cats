package com.ultronvision.bigcats.common.api.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author oldwei
 * @date 2022/7/15 15:08
 */
@Data
public class PageTableDTO<T> implements Serializable {
    private static final long serialVersionUID = -4910557393640781861L;
    Long pageSize;
    Long pageNo;
    Long totalCount;
    Long totalPage;
    List<T> data;
}
