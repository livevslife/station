package com.web.mvc.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.web.mvc.dao.IUserDao;
import com.web.mvc.model.UserBean;
import com.web.mvc.service.IUserService;

@Service
public class UserService implements IUserService {
	@Resource
	private IUserDao userdao;

	@Override
	public void addUser(UserBean userbean) throws Exception {
		// TODO Auto-generated method stub
		userdao.adduser(userbean);
	}

}
