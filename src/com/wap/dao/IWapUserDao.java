package com.wap.dao;

import java.util.List;

import com.wap.entity.WapUser;

public interface IWapUserDao {
  public List<WapUser> getLogin(WapUser user);
}
