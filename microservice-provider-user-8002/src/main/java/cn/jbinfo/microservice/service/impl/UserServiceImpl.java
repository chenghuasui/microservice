package cn.jbinfo.microservice.service.impl;


import cn.jbinfo.microservice.biz.User;
import cn.jbinfo.microservice.dao.UserDao;
import cn.jbinfo.microservice.service.UserService;
import org.omg.PortableInterceptor.USER_EXCEPTION;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class UserServiceImpl implements UserService
{
	@Autowired
	private UserDao dao;

	@Override
	public boolean add(User user)
	{
		return dao.addUser(user);
	}

	@Override
	public User get(String id)
	{
		return dao.findById(id);
	}

	@Override
	public List<User> list()
	{
		List<User> userList =dao.findAll();
		for (User u:userList) {
			System.out.print(u.getGeroId());
		}
		return dao.findAll();
	}

}
