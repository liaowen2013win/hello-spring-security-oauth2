/**
 * @(#)OAuth2ResourceApplication.java, 2019/12/23. 15:08
 * @Author: L.Wen
 * <p/>
 */
package com.funtl.spring.security.oauth2.resource;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import tk.mybatis.spring.annotation.MapperScan;

/**
 * @Author: L.Wen
 * @created_at: 2019/12/23 15:08
 */
@SpringBootApplication
@MapperScan(basePackages = "com.funtl.spring.security.oauth2.resource.mapper")
public class OAuth2ResourceApplication {
    public static void main(String[] args) {
        SpringApplication.run(OAuth2ResourceApplication.class, args);
    }
}
