package com.kuang.config;

import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


//AOP:橫切思想

@EnableWebSecurity   //开启security模式
public class SecurityConfig  extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		//首页所有人可以访问，功能只有对应权限的人才能访问

		//定制授权规则
		http.authorizeRequests()
				.antMatchers("/").permitAll()
				.antMatchers("/level1/**").hasRole("vip1")
				.antMatchers("/level2/**").hasRole("vip2")
				.antMatchers("/level3/**").hasRole("vip3");

		//没有权限默认会到登录界面(默认登录页面为/login)
		//定制登录页面
		//登录默认传的是password,username
		http.formLogin()
				.loginPage("/toLogin")
				.usernameParameter("user")
				.passwordParameter("pwd");

		//注销功能,注销后跳到首页
		http.logout().logoutSuccessUrl("/");

		//如果注销失败则关闭csrf
		http.csrf().disable();

		//记住我功能  默认时间两周,cookie,接收前端自定义的记住我参数
		http.rememberMe().rememberMeParameter("remember");
	}




	//认证
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		//从数据库中获取


		//从内存中获取
		//spring security 官方推荐的是使用bcrypt加密方式。
		auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder())
				.withUser("kuangshen").password(new BCryptPasswordEncoder().encode("981028")).roles("vip2","vip3")
				.and()
				.withUser("root").password(new BCryptPasswordEncoder().encode("123456")).roles("vip1","vip2","vip3")
				.and()
				.withUser("guest").password(new BCryptPasswordEncoder().encode("123456")).roles("vip1","vip2");
	}
}












































