package cn.jbinfo.microservice.service;


import java.util.List;

import cn.jbinfo.microservice.biz.User;

public interface UserService
{
	public boolean add(User user);


	public User get(String id) ;


	public List<User> list();
}
