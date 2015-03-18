package com.wap.service;

import java.util.List;

import com.wap.dao.IWapUserDao;
import com.wap.entity.WapUser;

public class WapUserManager implements IWapUserManager {

	private IWapUserDao wapUserDao;
	public IWapUserDao getWapUserDao() {
		return wapUserDao;
	}
	public void setWapUserDao(IWapUserDao wapUserDao) {
		this.wapUserDao = wapUserDao;
	}
	@Override
	public List<WapUser> getUser(WapUser user) {
		// TODO Auto-generated method stub
		return wapUserDao.getLogin(user);
	}

}
