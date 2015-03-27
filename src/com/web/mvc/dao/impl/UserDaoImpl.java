package com.web.mvc.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.web.mvc.dao.IUserDao;
import com.web.mvc.model.text;

@Repository(value = "userDao")
public class UserDaoImpl implements IUserDao {
	@Autowired
	@Qualifier("sessionFactory")
	private SessionFactory sessionFactory;

	public Session getSession() {
		// 事务必须是开启的，否则获取不到
		return sessionFactory.getCurrentSession();
	}

	@Override
	@Transactional
	public void adduser(text t) throws Exception {
		// TODO Auto-generated method stub
		this.getSession().save(t);
		System.out.println("save-------------------->");
	}
}
