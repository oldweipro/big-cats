package com.ultronvision.bigcats.common.util;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ultronvision.bigcats.common.constant.PageConstant;

import java.util.HashMap;
import java.util.Map;

/**
 * @author oldwei
 * @date 2021-6-8 16:30
 */
public class BigCatsUtil {
    public static Map<String, Object> getDataTable(IPage<?> pageInfo) {
        Map<String, Object> data = new HashMap<>(5);
        data.put(PageConstant.DATA, pageInfo.getRecords());
        data.put(PageConstant.TOTAL_COUNT, pageInfo.getTotal());
        data.put(PageConstant.PAGE_SIZE, pageInfo.getSize());
        data.put(PageConstant.PAGE_NO, pageInfo.getCurrent());
        data.put(PageConstant.TOTAL_PAGE, pageInfo.getPages());
        return data;
    }
}
