package com.funtl.spring.security.oauth2.server.service;

import com.funtl.spring.security.oauth2.server.domain.TbUser;

/**
 * @Author: L.Wen
 * @created_at: 2019/12/22 13:45
 */
public interface TbUserService {

    TbUser getByUsername(String username);

}
