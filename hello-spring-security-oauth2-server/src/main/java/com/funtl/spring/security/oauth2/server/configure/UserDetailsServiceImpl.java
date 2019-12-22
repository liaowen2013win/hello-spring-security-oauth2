/**
 * @(#)UserDetailsServiceImpl.java, 2019/12/22. 13:38
 * @Author: L.Wen
 * <p/>
 */
package com.funtl.spring.security.oauth2.server.configure;

import java.util.List;

import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.funtl.spring.security.oauth2.server.domain.TbPermission;
import com.funtl.spring.security.oauth2.server.domain.TbUser;
import com.funtl.spring.security.oauth2.server.service.TbPermissionService;
import com.funtl.spring.security.oauth2.server.service.TbUserService;

/**
 * @Author: L.Wen
 * @created_at: 2019/12/22 13:38
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private TbUserService tbUserService;

    @Autowired
    private TbPermissionService tbPermissionService;

    /**
     * 查询用户权限，并进行授权
     *
     * @param s
     * @return
     * @throws UsernameNotFoundException
     */
    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        TbUser tbUser = tbUserService.getByUsername(s);
        List<GrantedAuthority> grantedAuthorities = Lists.newArrayList();
        if (tbUser != null) {
            List<TbPermission> tbPermissions = tbPermissionService.selectByUserId(tbUser.getId());
            tbPermissions.forEach(tbPermission -> {
                GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(tbPermission.getEnname());
                grantedAuthorities.add(grantedAuthority);
            });
            return new User(tbUser.getUsername(), tbUser.getPassword(), grantedAuthorities);
        }
        return null;
    }
}
