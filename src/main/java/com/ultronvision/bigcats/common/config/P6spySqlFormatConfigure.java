package com.ultronvision.bigcats.common.config;

import cn.hutool.core.util.StrUtil;
import com.p6spy.engine.spy.appender.MessageFormattingStrategy;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * 自定义 p6spy sql输出格式
 *
 * @author oldwei
 * @date 2021/5/31 5:09 下午
 */
public class P6spySqlFormatConfigure implements MessageFormattingStrategy {
    /**
     * 过滤掉定时任务的 SQL
     */
    @Override
    public String formatMessage(int connectionId, String now, long elapsed, String category, String prepared, String sql, String url) {
        return StrUtil.isNotBlank(sql) ? LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"))
                + " | 耗时 " + elapsed + " ms | SQL 语句：" + StrUtil.LF + sql.replaceAll("[\\s]+", StrUtil.SPACE) + ";" : StrUtil.EMPTY;
    }
}
