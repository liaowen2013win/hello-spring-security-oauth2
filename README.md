# hello-spring-security-oauth2
## spring-cloud-security-oauth2微服务架构认证授权

### 基于 内存存储令牌 的模式用于演示最基本的操作，帮助大家快速理解 oAuth2 认证服务器中 "认证"、"授权"、"访问令牌” 的基本概念

#### Using generated security password: d2580683-d247-47d6-b9f9-421d1c02c1f0

### 操作流程图：
![Image](http://www.qfdmy.com/wp-content/uploads/2019/08/253eb4ef0c03ae7.png)

####配置认证服务器
#####配置客户端信息：ClientDetailsServiceConfigurer
######inMemory：内存配置
######withClient：客户端标识
######secret：客户端安全码
######authorizedGrantTypes：客户端授权类型
######scopes：客户端授权范围
######redirectUris：注册回调地址
####配置 Web 安全
#####通过 GET 请求访问认证服务器获取授权码
######端点：/oauth/authorize
#####通过 POST 请求利用授权码访问认证服务器获取令牌
######端点：/oauth/token
###默认的端点 URL
####/oauth/authorize：授权端点
####/oauth/token：令牌端点
####/oauth/confirm_access：用户确认授权提交端点
####/oauth/error：授权服务错误信息端点
####/oauth/check_token：用于资源服务访问的令牌解析端点
####/oauth/token_key：提供公有密匙的端点，如果你使用 JWT 令牌的话
##服务器安全配置
创建一个类继承 WebSecurityConfigurerAdapter 并添加相关注解：

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)：全局方法拦截
##配置认证服务器
创建一个类继承 AuthorizationServerConfigurerAdapter 并添加相关注解：

@Configuration
@EnableAuthorizationServer
