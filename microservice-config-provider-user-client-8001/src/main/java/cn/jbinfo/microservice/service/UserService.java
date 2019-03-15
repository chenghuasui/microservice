package cn.jbinfo.microservice.service;


import cn.jbinfo.microservice.biz.user.domain.User;

import java.util.List;


public interface UserService
{
	public boolean add(User user);


	public User get(String id) ;


	public List<User> list();
}
