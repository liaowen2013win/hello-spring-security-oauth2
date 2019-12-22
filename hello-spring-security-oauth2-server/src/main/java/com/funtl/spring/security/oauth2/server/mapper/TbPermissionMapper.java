package com.funtl.spring.security.oauth2.server.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.funtl.spring.security.oauth2.server.domain.TbPermission;

import tk.mybatis.mapper.MyMapper;

public interface TbPermissionMapper extends MyMapper<TbPermission> {

    List<TbPermission> selectByUserId(@Param("userId") Long userId);
}