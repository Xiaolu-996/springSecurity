package com.kuang.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class RouterController {

	@RequestMapping({"/","/index"})     //可以传数组
	public String index(){
		System.out.println("index Controller");
		return ("index");
	}

	@RequestMapping("/toLogin")
	public String toLogin(){
		System.out.println("toLogin Controller");
		return ("views/login");     //进入的界面
	}

	//根据传入id的不同可以跳转到level1下面的不同界面
    @RequestMapping("/level1/{id}")
	public String level1(@PathVariable("id") int id){
		System.out.println("level1 Controller");
		return ("views/level1/"+id);     //进入的界面
	}

	//根据传入id的不同可以跳转到level1下面的不同界面
	@RequestMapping("/level2/{id}")
	public String level2(@PathVariable("id") int id){
		System.out.println("level2 Controller");
		return ("views/level2/"+id);     //进入的界面
	}


	//根据传入id的不同可以跳转到level1下面的不同界面
	@RequestMapping("/level3/{id}")
	public String level3(@PathVariable("id") int id){
		System.out.println("level3 Controller");
		return ("views/level3/"+id);     //进入的界面
	}



}
