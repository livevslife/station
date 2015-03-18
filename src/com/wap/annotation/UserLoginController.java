package com.wap.annotation;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;


import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wap.entity.SmsUtils;
import com.wap.entity.WapUser;
import com.wap.service.IWapUserManager;

@Controller
public class UserLoginController {
	@Resource(name = "wapUserManager")
	private IWapUserManager wapUserManager;

	@RequestMapping("/login.do")
	@ResponseBody
	public SmsUtils login(WapUser user,HttpSession session) {
		List<WapUser> res=wapUserManager.getUser(user);
		SmsUtils sms=new SmsUtils();
		if (res.size()!=0) {
            session.setAttribute("userid", wapUserManager.getUser(user).get(0).getId().toString());
            session.setAttribute("username", wapUserManager.getUser(user).get(0).getUsername().toString());
            sms.setSms("success");
		} else {
			sms.setSms("帐号/密码不正确!");
		}
		return sms;
	}
	@RequestMapping("/loginout.do")
	public String loginout(HttpSession session) {
		session.removeAttribute("username");
		session.removeAttribute("userid");
		return "index";
	}

	@RequestMapping("/wap.do")
	public String wap() {
		return "wap";
	}

	@RequestMapping("/html5.do")
	public String html5() {
		return "html5";
	}

	@RequestMapping("/text.do")
	public String text() {
		return "text";
	}

	@RequestMapping("/index.do")
	public String index() {
		return "index";
	}
	@RequestMapping("/welcome.do")
	public String welcome() {
		return "welcome";
	}
	@RequestMapping("/nav.do")
	public String nav() {
		return "ResponsiveNav";
	}
}
