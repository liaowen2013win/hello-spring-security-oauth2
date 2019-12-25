package com.funtl.spring.security.oauth2.resource.service.impl;

import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import com.funtl.spring.security.oauth2.resource.mapper.TbContentCategoryMapper;
import com.funtl.spring.security.oauth2.resource.service.TbContentCategoryService;
/**
 * @Author:    L.Wen
 * @created_at:    2019/12/23 16:19
 */
@Service
public class TbContentCategoryServiceImpl implements TbContentCategoryService{

    @Resource
    private TbContentCategoryMapper tbContentCategoryMapper;

}
