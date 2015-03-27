package com.web.mvc.service;

import org.springframework.transaction.annotation.Transactional;

import com.web.mvc.model.text;

public interface IUserService {
	
	public void addUser(text t) throws Exception;
}
