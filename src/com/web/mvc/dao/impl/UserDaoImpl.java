package com.web.mvc.dao.impl;

import javax.annotation.Resource;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import com.web.mvc.dao.IUserDao;
import com.web.mvc.model.UserBean;

@Repository
public class UserDaoImpl implements IUserDao {
	@Resource
	private SessionFactory sessionFactory;

	protected Session getSession() {
		return sessionFactory.getCurrentSession();
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void adduser(UserBean userbean) throws Exception {
		// TODO Auto-generated method stub
		Session session = this.getSession();
		session.save(userbean);
	}
}
