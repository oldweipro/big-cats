package com.ultronvision.bigcats.modules.cats.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ultronvision.bigcats.common.entity.cats.SysUser;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author oldwei
 * @date 2021/5/31 5:21 下午
 */
public interface SysUserMapper extends BaseMapper<SysUser> {
    /**
     * 查询用户的所有权限
     *
     * @param userId 用户ID
     * @return
     */
    @Select("select m.perms from sys_user_role ur " +
            "LEFT JOIN sys_role_menu rm on ur.role_id = rm.role_id " +
            "LEFT JOIN sys_menu m on rm.menu_id = m.id " +
            "where ur.user_id = #{userId} and ur.del_flag = 0")
    List<String> queryAllPerms(Long userId);
}
