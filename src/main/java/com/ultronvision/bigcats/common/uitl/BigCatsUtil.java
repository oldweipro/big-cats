package com.ultronvision.bigcats.common.uitl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ultronvision.bigcats.common.api.dto.PageTableDTO;

public class BigCatsUtil {
    /**
     * 封装前端分页表格所需数据
     *
     * @param pageInfo pageInfo
     * @return Map<String, Object>
     */
    public static <T> PageTableDTO<T> getDataTable(IPage<T> pageInfo) {
        PageTableDTO<T> pageTableDTO = new PageTableDTO<>();
        pageTableDTO.setPageNo(pageInfo.getCurrent());
        pageTableDTO.setPageSize(pageInfo.getSize());
        pageTableDTO.setTotalCount(pageInfo.getTotal());
        pageTableDTO.setTotalPage(pageInfo.getPages());
        pageTableDTO.setData(pageInfo.getRecords());
        return pageTableDTO;
    }
}
