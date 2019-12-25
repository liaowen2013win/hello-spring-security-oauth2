package com.funtl.spring.security.oauth2.resource.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import javax.annotation.Resource;

import com.funtl.spring.security.oauth2.resource.domain.TbContent;
import com.funtl.spring.security.oauth2.resource.mapper.TbContentMapper;
import com.funtl.spring.security.oauth2.resource.service.TbContentService;

/**
 * @Author: L.Wen
 * @created_at: 2019/12/23 16:19
 */
@Service
public class TbContentServiceImpl implements TbContentService {

    @Resource
    private TbContentMapper tbContentMapper;

    @Override
    public List<TbContent> selectAll() {
        return tbContentMapper.selectAll();
    }
}
