/**
 * @(#)TbContentController.java, 2019/12/23. 16:40
 * @Author: L.Wen
 * <p/>
 */
package com.funtl.spring.security.oauth2.resource.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.funtl.spring.security.oauth2.resource.domain.TbContent;
import com.funtl.spring.security.oauth2.resource.dto.ResponseResult;
import com.funtl.spring.security.oauth2.resource.service.TbContentService;

/**
 * @Author: L.Wen
 * @created_at: 2019/12/23 16:40
 */
@RestController
public class TbContentController {

    @Autowired
    private TbContentService tbContentService;

    @GetMapping(value = "/")
    public ResponseResult<List<TbContent>> list() {
        List<TbContent> tbContents = tbContentService.selectAll();
        return new ResponseResult<List<TbContent>>(HttpStatus.OK.value(), HttpStatus.OK.toString(), tbContents);
    }
}
