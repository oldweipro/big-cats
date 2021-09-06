package com.ultronvision.bigcats.common.config.mybatis;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.MybatisPlusInterceptor;
import com.baomidou.mybatisplus.extension.plugins.handler.TenantLineHandler;
import com.baomidou.mybatisplus.extension.plugins.inner.PaginationInnerInterceptor;
import com.baomidou.mybatisplus.extension.plugins.inner.TenantLineInnerInterceptor;
import com.ultronvision.bigcats.common.constant.CommonConstant;
import lombok.extern.slf4j.Slf4j;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.expression.LongValue;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * mybatis-plus 配置
 *
 * @author oldwei
 * @date 2021/5/31 5:06 下午
 */
@Slf4j
@Configuration
@MapperScan(value = {"com.ultronvision.bigcats.modules.*.mapper"})
public class MybatisPlusConfig {
    /**
     * 哪些表需要做多租户 表需要添加一个字段 tenant_id
     */
    private static final List<String> tenantTable = new ArrayList<String>();

    static {
        tenantTable.add("sys_user");
    }

    /**
     * 新的分页插件,一缓和二缓遵循mybatis的规则,需要设置 MybatisConfiguration#useDeprecatedExecutor = false 避免缓存出现问题
     * 新多租户插件配置,一缓和二缓遵循mybatis的规则,需要设置 MybatisConfiguration#useDeprecatedExecutor = false 避免缓存万一出现问题
     */
    @Bean
    public MybatisPlusInterceptor mybatisPlusInterceptor() {
        MybatisPlusInterceptor interceptor = new MybatisPlusInterceptor();
        interceptor.addInnerInterceptor(new TenantLineInnerInterceptor(new TenantLineHandler() {
            @Override
            public Expression getTenantId() {
                HttpServletRequest request = null;
                // 从当前系统上下文中取出当前请求的服务商ID，通过解析器注入到SQL中。
                if (null != RequestContextHolder.getRequestAttributes()) {
                    request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
                }
                String currentTenantId;
                try {
                    String tenantId;
                    if (null == request) {
                        tenantId = "0";
                    } else {
                        tenantId = request.getHeader(CommonConstant.TENANT_ID);
                        if (StringUtils.isBlank(tenantId)) {
                            HttpSession session = request.getSession();
                            tenantId = session.getAttribute(tenantId) == null ? null : session.getAttribute(tenantId).toString();
                        }
                        if (StringUtils.isBlank(tenantId)) {
                            tenantId = "0";
                        }
                    }
                    currentTenantId = tenantId;
                } catch (Exception e) {
                    throw new RuntimeException("getTenantId error.");
                }
                return new LongValue(currentTenantId);
            }

            // 这是 default 方法,默认返回 false 表示所有表都需要拼多租户条件
            @Override
            public boolean ignoreTable(String tableName) {
                HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
                String tenantId = request.getHeader(CommonConstant.TENANT_ID);
                if (StrUtil.equals("0", StrUtil.isBlankIfStr(tenantId) ? "0" : tenantId)) {
                    if (StrUtil.equals("sys_user", tableName) || StrUtil.equals("sys_user_token", tableName)) {
                        return true;
                    } else {
                        return false;
                    }
                } else {
                    for (String temp : tenantTable) {
                        if (temp.equalsIgnoreCase(tableName)) {
                            return false;
                        }
                    }
                }
                return true;
            }
        }));
        //如果用了分页插件注意先 add TenantLineInnerInterceptor 再 add PaginationInnerInterceptor
        PaginationInnerInterceptor paginationInterceptor = new PaginationInnerInterceptor();
        paginationInterceptor.setDbType(DbType.MYSQL);
        interceptor.addInnerInterceptor(paginationInterceptor);
        return interceptor;
    }

}
