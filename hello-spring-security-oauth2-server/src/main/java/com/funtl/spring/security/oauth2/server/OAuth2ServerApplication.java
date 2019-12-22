/**
 * @(#)OAuth2ServerApplication.java, 2019/12/15. 14:30
 * @Author: L.Wen
 * <p/>
 */
package com.funtl.spring.security.oauth2.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import tk.mybatis.spring.annotation.MapperScan;

/**
 * @Author: L.Wen
 * @created_at: 2019/12/15 14:30
 */
@SpringBootApplication
@MapperScan(basePackages = "com.funtl.spring.security.oauth2.server.mapper")
public class OAuth2ServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(OAuth2ServerApplication.class, args);
    }
}
