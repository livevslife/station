package com.wap.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;

import com.wap.entity.WapUser;

public class WapUserDao implements IWapUserDao {

	private SessionFactory sessionFactory;

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	// 执行操作所需要的表
	private String table = "wap_user";

	// 登陆查询用户是否存在
	@Override
	public List<WapUser> getLogin(WapUser user) {
		String hql = "from wap_user u where u.username =? and u.password=?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, user.getUsername());
		query.setString(1, user.getPassword());
		// List<WapUser> list= query.list();
		// return list.size()!=0;
		return query.list();
	}

}
