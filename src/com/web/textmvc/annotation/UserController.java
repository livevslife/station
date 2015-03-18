package com.web.textmvc.annotation;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.web.textmvc.entity.User;
import com.web.textmvc.service.IUserManager;
import com.web.uity.Md5;

/**
 * User控制层 SpringMVC 控制器Controller
 * 
 * @author Administrator
 * 
 */

@Controller
//@RequestMapping("/user")
public class UserController {
	//获取继承了事务管理类
	//将组件（bean）userManager注入到该类中
	@Resource(name = "userManager")
	private IUserManager userManager;

	@RequestMapping(value = "/addUser")
	public String addUser(User user,HttpServletRequest request) {
		user.setAge(Md5.make(user.getAge()));
        userManager.addUser(user);
        List<User> list =userManager.getAllUser();
       request.setAttribute("list",list ); 
		return "success";
	}
	@RequestMapping(value = "/getAllUser")
	public String getAllUser(HttpServletRequest request) {
        List<User> list =userManager.getAllUser();
       request.setAttribute("list",list ); 
		return "success";
	}
	@RequestMapping(value = "/User")
	public String User() {
		return "adduser";
	}
	@RequestMapping(value = "/delUser")
	public void delUser(String id,HttpServletResponse response) {
		String result=null;
		if(userManager.delUser(id)){
			result ="{\"del\":\"success\"}";
		}else{
			result="{\"del\":\"error\"}";
		}
		PrintWriter out=null;
		response.setContentType("application/json");
		try {
			out=response.getWriter();
			out.write(result);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	@RequestMapping(value = "/getUser")
	public String getUser(String id,HttpServletRequest request) {
		request.setAttribute("user", userManager.getUser(id));
		return "edituser";
	}
	@RequestMapping(value = "/updateUser")
	public void updateUser(User user,HttpServletResponse response) {
		String result=null;
		if(userManager.updateUser(user)){
			result ="{\"update\":\"success\"}";
		}else{
			result="{\"update\":\"error\"}";
		}
		PrintWriter out=null;
		response.setContentType("application/json");
		try {
			out=response.getWriter();
			out.write(result);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
}
