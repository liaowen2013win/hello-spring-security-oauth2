/**
 * @(#)OAuth2ServerApplicationTests.java, 2019/12/21. 18:41
 * @Author: L.Wen
 * <p/>
 */
package com.funtl.spring.security.oauth2.server;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Author: L.Wen
 * @created_at: 2019/12/21 18:41
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OAuth2ServerApplicationTests {

    /**
     * 测试加密
     */
    @Test
    public void testPasswordEncoder() {
        System.out.println("加密后的：" + new BCryptPasswordEncoder().encode("admin888"));

    }
}
