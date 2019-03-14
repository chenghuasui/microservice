package cn.jbinfo.microservice.dao;

import cn.jbinfo.microservice.biz.user.domain.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;


@Mapper
public interface UserDao
{
	public boolean addUser(User user);

	public User findById(String id);

	public List<User> findAll();
}
