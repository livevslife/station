package com.web.mvc.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.web.mvc.dao.IUserDao;
import com.web.mvc.model.text;
import com.web.mvc.service.IUserService;

@Service("UserServiceImpl")
public class UserService implements IUserService {
	@Autowired
	private IUserDao userdao;

	@Transactional
	public void addUser(text t) throws Exception {
		// TODO Auto-generated method stub
		userdao.adduser(t);
	}

}
