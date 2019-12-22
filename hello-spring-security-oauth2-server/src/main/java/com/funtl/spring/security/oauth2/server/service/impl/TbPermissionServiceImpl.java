package com.funtl.spring.security.oauth2.server.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.funtl.spring.security.oauth2.server.domain.TbPermission;
import com.funtl.spring.security.oauth2.server.mapper.TbPermissionMapper;
import com.funtl.spring.security.oauth2.server.service.TbPermissionService;

/**
 * @Author: L.Wen
 * @created_at: 2019/12/22 13:46
 */
@Service
public class TbPermissionServiceImpl implements TbPermissionService {

    @Resource
    private TbPermissionMapper tbPermissionMapper;

    /**
     * 根据用户id查询权限
     *
     * @param userId
     * @return
     */
    @Override
    public List<TbPermission> selectByUserId(Long userId) {
        return tbPermissionMapper.selectByUserId(userId);
    }
}
