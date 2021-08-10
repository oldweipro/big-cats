package com.ultronvision.bigcats.common.util;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.ultronvision.bigcats.common.constant.PageConstant;
import com.ultronvision.bigcats.common.entity.hik.Device;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

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

    public static String httpPost(String url, Object obj) {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Object> requestEntity = new HttpEntity<>(obj, httpHeaders);
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForObject(url, requestEntity, String.class);
    }

    public static String httpGet(String url) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(url, String.class);
    }
}
