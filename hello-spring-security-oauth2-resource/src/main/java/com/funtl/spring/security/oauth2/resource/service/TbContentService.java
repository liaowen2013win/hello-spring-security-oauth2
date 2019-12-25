package com.funtl.spring.security.oauth2.resource.service;

import java.util.List;

import com.funtl.spring.security.oauth2.resource.domain.TbContent;

/**
 * @Author: L.Wen
 * @created_at: 2019/12/23 16:19
 */
public interface TbContentService {

    List<TbContent> selectAll();
}
