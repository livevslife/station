package com.web.textmvc.service;

import java.util.List;

import com.web.textmvc.dao.IUserDao;
import com.web.textmvc.entity.User;

/**
 * service业务层只要没访问数据库都要业务里写
 * 
 * @author Administrator
 * 
 */
public class UserManager implements IUserManager {

	// UserDao get,set 要注入
	private IUserDao userDao;

	public IUserDao getUserDao() {
		return userDao;
	}

	public void setUserDao(IUserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public void addUser(User user) {
		userDao.addUser(user);
	}

	@Override
	public List<User> getAllUser() {
		return userDao.getAllUser();
	}

	@Override
	public boolean delUser(String id) {
		return userDao.delUser(id);
	}

	@Override
	public User getUser(String id) {
		return userDao.getUser(id);
	}

	@Override
	public boolean updateUser(User user) {
		return userDao.updateUser(user);
	}

}
