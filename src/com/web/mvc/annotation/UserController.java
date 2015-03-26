package com.web.mvc.annotation;

import java.io.IOException;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.web.mvc.dto.UserDto;
import com.web.mvc.model.UserBean;
import com.web.mvc.service.IUserService;

/**
 * User控制层 SpringMVC 控制器Controller
 * 
 * @author Administrator
 * 
 */

@Controller
// @RequestMapping("/user")
public class UserController {
	// 获取继承了事务管理类
	// 将组件（bean）userManager注入到该类中
	private static final Log log = LogFactory.getLog(UserController.class);

	private IUserService userService;

	@RequestMapping(value = "/add")
	public String add(UserDto userdto, HttpServletRequest request) {
		UserBean userbean = new UserBean();
		userbean.setUsername(userdto.getUsername());
		userbean.setAge(userdto.getAge());

		try {
			userService.addUser(userbean);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "adduser";
	}

	@RequestMapping(value = "/adduser")
	public String adduser() {
		return "adduser";
	}

	@RequestMapping(value = "/main")
	public String main() {
		return "main";
	}

	@RequestMapping(value = "/top")
	public String top() {
		return "top";
	}

	@RequestMapping(value = "/index")
	public String index() {
		return "index";
	}

	@RequestMapping(value = "/Default")
	public String Default() {
		return "default";
	}

	@RequestMapping(value = "/left")
	public String left() {
		return "left";
	}

	@RequestMapping(value = "/form")
	public String form() {
		return "form";
	}

	@RequestMapping(value = "/imglist")
	public String imglist() {
		return "imglist";
	}

	@RequestMapping(value = "/imgtable")
	public String imgtable() {
		return "imgtable";
	}

	@RequestMapping(value = "/imglist1")
	public String imglist1() {
		return "imglist1";
	}

	@RequestMapping(value = "/tools")
	public String tools() {
		return "tools";
	}

	@RequestMapping(value = "/filelist")
	public String filelist() {
		return "filelist";
	}

	@RequestMapping(value = "/tab")
	public String tab() {
		return "tab";
	}

	@RequestMapping(value = "/error")
	public String error() {
		return "error";
	}

	@RequestMapping(value = "/right")
	public String right() {
		return "right";
	}

	@RequestMapping(value = "/computer")
	public String computer() {
		return "computer";
	}

	// @RequestMapping(value = "/addUser")
	// public String addUser(UserDto user, HttpServletRequest request) {
	// user.setAge(Md5.make(user.getAge()));
	// userManager.addUser(user);
	// List<UserBean> list = userManager.getAllUser();
	// request.setAttribute("list", list);
	// return "success";
	// }
	//
	// @RequestMapping(value = "/adddata")
	// public String adddata(UserBean user, HttpServletRequest request) {
	//
	// request.setAttribute("list", "ok");
	// return "test";
	// }
	//
	// @RequestMapping(value = "/getAllUser")
	// public String getAllUser(HttpServletRequest request) {
	// List<UserBean> list = userManager.getAllUser();
	// request.setAttribute("list", list);
	// return "success";
	// }
	//
	// @RequestMapping(value = "/delUser")
	// public void delUser(String id, HttpServletResponse response) {
	// String result = null;
	// if (userManager.delUser(id)) {
	// result = "{\"del\":\"success\"}";
	// } else {
	// result = "{\"del\":\"error\"}";
	// }
	// PrintWriter out = null;
	// response.setContentType("application/json");
	// try {
	// out = response.getWriter();
	// out.write(result);
	// } catch (IOException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	// }
	//
	// @RequestMapping(value = "/getUser")
	// public String getUser(String id, HttpServletRequest request) {
	// request.setAttribute("user", userManager.getUser(id));
	// return "edituser";
	// }
	//
	// @RequestMapping(value = "/updateUser")
	// public void updateUser(UserBean user, HttpServletResponse response) {
	// String result = null;
	// if (userManager.updateUser(user)) {
	// result = "{\"update\":\"success\"}";
	// } else {
	// result = "{\"update\":\"error\"}";
	// }
	// PrintWriter out = null;
	// response.setContentType("application/json");
	// try {
	// out = response.getWriter();
	// out.write(result);
	// } catch (IOException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	// }
}
