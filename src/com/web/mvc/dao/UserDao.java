package com.web.mvc.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SessionFactory;

import com.web.mvc.entity.User;

/**
 * dao数据访问层 DAO层一般有接口和该接口的实现类！ 接口用于规范实现类！ 实现类一般用于用于操作数据库
 * 
 * @author Administrator
 * 
 */
public class UserDao implements IUserDao {
	// spring 4.0以后,主不用spring操作sessionFactory,
	// 注入sessionFactory ,就可以操作数据库
	private SessionFactory sessionFactory;
	private String table = "textmvc_user";

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	// 添加用户信息
	public void addUser(User user) {
		sessionFactory.getCurrentSession().save(user);
		System.out.println("save---->" + user.getUsername());
	}

	@Override
	public List<User> getAllUser() {
		String hql = "from "+table;
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		return query.list();
	}

	public boolean delUser(String id) {
		String hql = "delete "+table+" u where u.id=?";
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		query.setString(0, id);
		return query.executeUpdate() > 0;
	}

	@Override
	public User getUser(String id) {
       String hql="from "+table+" u where u.id=?";
       Query query=sessionFactory.getCurrentSession().createQuery(hql);
       query.setString(0, id);
		return (User) query.uniqueResult();
	}

	@Override
	public boolean updateUser(User user) {
	   String hql="update "+table+" u set u.username=?,u.age=? where u.id=?";
	   Query query=sessionFactory.getCurrentSession().createQuery(hql);
	   query.setString(0,user.getUsername());
	   query.setString(1, user.getAge());
	   query.setString(2, user.getId());
		return query.executeUpdate()>0;
	}

}
