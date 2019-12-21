/**
 * @(#)AuthorizationServerConfiguration.java, 2019/12/21. 17:59
 * @Author: L.Wen
 * <p/>
 */
package com.funtl.spring.security.oauth2.server.configure;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.provider.ClientDetailsService;
import org.springframework.security.oauth2.provider.client.JdbcClientDetailsService;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.JdbcTokenStore;

/**
 * 配置认证服务器
 *
 * @Author: L.Wen
 * @created_at: 2019/12/21 17:59
 */
@Configuration
@EnableAuthorizationServer
public class AuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter {

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    /**
     * 1. 重写datasource，来读取数据库连接配置
     */
    @Bean
    @Primary
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource dataSource() {
        // 配置数据源（注意，我使用的是 HikariCP 连接池），以上注解是指定数据源，否则会有冲突
        return DataSourceBuilder.create().build();
    }

    /**
     * 2. 使用数据库存储token，指定数据源
     * 基于 JDBC 实现，令牌保存到数据库
     *
     * @return
     */
    @Bean
    public TokenStore tokenStore() {
        return new JdbcTokenStore(dataSource());
    }

    /**
     * 3. 指定ClientDetailsService，从数据库获取client信息
     * 基于 JDBC 实现，需要事先在数据库配置客户端信息
     *
     * @return
     */
    @Bean
    public ClientDetailsService jdbcClientDetailsService() {
        return new JdbcClientDetailsService(dataSource());
    }

    /**
     * 设置令牌存储模式
     *
     * @param endpointsConfiguration
     */
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpointsConfiguration) {
        endpointsConfiguration.tokenStore(tokenStore());
    }

    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        // 配置客户端：使用数据库方式存储
        clients.withClientDetails(jdbcClientDetailsService());
    }

}
