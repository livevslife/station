package com.web.uity;

import com.web.mvc.dao.IUserDao;
import com.web.mvc.model.UserBean;

public class Test {

	private IUserDao userdao;

	public void testSave() {
		UserBean user = new UserBean();
		user.setUsername("text");
		user.setAge("14");
		try {
			userdao.adduser(user);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
