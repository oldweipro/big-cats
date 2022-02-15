package com.ultronvision.bigcats.modules.cats.service.impl;

import cn.hutool.core.util.RandomUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ultronvision.bigcats.modules.cats.entity.SysUserToken;
import com.ultronvision.bigcats.modules.cats.mapper.SysUserTokenMapper;
import com.ultronvision.bigcats.modules.cats.service.ISysUserTokenService;
import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

/**
 * @author oldwei
 * @date 2021/5/31 6:30 下午
 */
@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly = true)
public class SysUserTokenServiceImpl extends ServiceImpl<SysUserTokenMapper, SysUserToken> implements ISysUserTokenService {
    /**
     * 12小时后过期
     */
    private final static int EXPIRE = 3600 * 12;

    @Override
    public String createToken(long userId) {
        //生成一个token
        String token = RandomUtil.randomString(32);

        //当前时间
        Date now = new Date();
        //过期时间
        Date expireTime = new Date(now.getTime() + EXPIRE * 1000);

        //判断是否生成过token
        SysUserToken tokenEntity = this.getById(userId);
        if (tokenEntity == null) {
            tokenEntity = new SysUserToken();
            tokenEntity.setUserId(userId);
            tokenEntity.setToken(token);
            tokenEntity.setUpdateTime(now);
            tokenEntity.setExpireTime(expireTime);

            //保存token
            this.save(tokenEntity);
        } else {
            tokenEntity.setToken(token);
            tokenEntity.setUpdateTime(now);
            tokenEntity.setExpireTime(expireTime);

            //更新token
            this.updateById(tokenEntity);
        }
        return token;
    }
    @Override
    public void logout(long userId) {
        //生成一个token
        String token = RandomUtil.randomString(32);

        //修改token
        SysUserToken userToken = new SysUserToken();
        userToken.setUserId(userId);
        userToken.setToken(token);
        this.updateById(userToken);
        //调用shiro的logout
        SecurityUtils.getSubject().logout();
    }
}
