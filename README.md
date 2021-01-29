# springSecurity
:see_no_evil:  A demo of springSecurity，学习springsecurity时的小demo
## SpringSecurity 
## 意义：
- 功能性需求：否
- web开发中安全第一位   （过滤器拦截器）
- 在设计之初就要考虑安全 
- 针对spring项目的安全框架,无缝衔接springboot

## 主流安全框架：
- SringSecurity、Shiro：很相似除了类名和名字不一样
- 主要功能：认证和授权
- Aop横向切入思想  


## 认证和授权
### 认证（Authentication）—— 主要是登录功能

- 身份验证是关于验证您的凭据，如用户名/用户ID和密码，以验证您的身份。

- 身份验证通常通过用户名和密码完成，有时与身份验证因素结合使用。

### 授权（Authorization）—— Http界面跳转

- 授权发生在系统成功验证您的身份后，最终会授予您访问资源（如信息，文件，数据库，资金，位置，几乎任何内容）的完全权限。



## springsecurity重要类（用空再写一下设计模式的笔记）
 1. WebSecurityConfigurerAdapter：自定义Security策略,springconfig配置类继承了该类（适配器模式） 
 2. HttpSecurity:自定义授权策略（建造者模式）   
 3. AuthenticationManagerBuilder：自定义认证策略（建造者模式）   
 4. @EnableWebSecurity：开启WebSecurity模式   @EnableXXXX开启某个功能

## 外部操作流程
1. 创建springsecurity项目（创建时就可导入Themeleleaf）
2. 关闭Themeleleaf模板引擎缓存
3. 导入静态资源（一些前端测试界面,安利一下semantic-ui这个前端框架,layui也不错）
4. 创建config和Controller文件夹,编辑Controller测试环境是否ok
5. pom文件中startsecurity,编写一个springsecurity配置类

## 内部操作流程（Securityconfig类）
1.在SecurityConfig类上加入注解
2.该类继承WebSecurityConfigurerAdapter
3.重写configure(HttpSecurity http)方法  定制授权规则
4.重写configure(AuthenticationManagerBuilder auth)方法 定制认证规则


### 总结
1.授权：
- 用户界面访问授权
- 登录页面的定制及登录时传递的参数定制（可修改默认登录界面）
- 注销功能,注销后可跳转到指定界面。如果注销失败则关闭csrf
- 记住我功能,注意前端传入的参数名

2.认证：（以从内存中获取为例,后面用了数据库再加上）
- 用户、密码、角色
- 必须开启加密才可以登录

3.Themeleleaf整合springsecurity
- pom导入 thymeleaf-security
- 导入命名空间 
- 未登录时显示登录按钮,登录成功显示用户名和角色信息及注销按钮
- 角色功能块认证,不同权限显示不同的功能块

4.其它
- sec标签不提示问题
- springboot版本使用2.0.x（高版本无法适配）
