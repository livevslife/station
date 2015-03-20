package com.web.mvc.service;

import java.util.List;

import com.web.mvc.entity.User;

public interface IUserManager {
	public void addUser(User user);
	public List<User> getAllUser();
	public boolean delUser(String id);
	
	public User getUser(String id);
	public boolean updateUser(User user);
}
