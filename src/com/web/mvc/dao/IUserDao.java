package com.web.mvc.dao;

import java.util.List;

import com.web.mvc.entity.User;

/**
 * UserDao接口
 * 
 * @author Administrator
 * 
 */
public interface IUserDao {
	public void addUser(User user);
	public List<User> getAllUser();
	public boolean delUser(String id);
	public User getUser(String id);
	public boolean updateUser(User user);
}
