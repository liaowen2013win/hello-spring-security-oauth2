package com.funtl.spring.security.oauth2.server.service.impl;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.funtl.spring.security.oauth2.server.domain.TbUser;
import com.funtl.spring.security.oauth2.server.mapper.TbUserMapper;
import com.funtl.spring.security.oauth2.server.service.TbUserService;

import tk.mybatis.mapper.entity.Example;

/**
 * @Author: L.Wen
 * @created_at: 2019/12/22 13:45
 */
@Service
public class TbUserServiceImpl implements TbUserService {

    @Resource
    private TbUserMapper tbUserMapper;

    @Override
    public TbUser getByUsername(String username) {

        Example example = new Example(TbUser.class);
        example.createCriteria().andEqualTo("username", username);

        return tbUserMapper.selectOneByExample(example);
    }
}
