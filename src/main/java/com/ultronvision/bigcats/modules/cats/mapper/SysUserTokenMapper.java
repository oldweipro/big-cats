package com.ultronvision.bigcats.modules.cats.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ultronvision.bigcats.modules.cats.entity.pojo.SysUserToken;
import org.apache.ibatis.annotations.Select;

/**
 * @author oldwei
 * @date 2021/5/31 5:23 下午
 */
public interface SysUserTokenMapper extends BaseMapper<SysUserToken> {
    /**
     * 根据accessToken，查询用户信息
     *
     * @param token
     * @return
     */
    @Select("select * from sys_user_token where token = #{value} and del_flag = 0")
    SysUserToken queryByToken(String token);
}
