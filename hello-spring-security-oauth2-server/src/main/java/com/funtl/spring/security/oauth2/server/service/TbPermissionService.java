package com.funtl.spring.security.oauth2.server.service;

import java.util.List;

import com.funtl.spring.security.oauth2.server.domain.TbPermission;

/**
 * @Author: L.Wen
 * @created_at: 2019/12/22 13:46
 */
public interface TbPermissionService {

    List<TbPermission> selectByUserId(Long userId);
}
