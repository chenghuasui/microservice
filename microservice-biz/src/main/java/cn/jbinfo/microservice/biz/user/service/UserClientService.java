package cn.jbinfo.microservice.biz.user.service;

import cn.jbinfo.microservice.biz.user.domain.User;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;


/**
 * 
 * @Description: 修改microservice-api工程，根据已经有的UserClientService接口

新建

一个实现了FallbackFactory接口的类DeptClientServiceFallbackFactory
 * @author zzyy
 * @date 2018年4月21日
 */
//@FeignClient(value = "MICROSERVICE-USER")
@FeignClient(value = "MICROSERVICE-USER",fallbackFactory=UserClientServiceFallbackFactory.class)
public interface UserClientService
{
	@RequestMapping(value = "/user/get/{id}", method = RequestMethod.GET)
	public User get(@PathVariable("id") String id);

	@RequestMapping(value = "/user/list", method = RequestMethod.GET)
	public List<User> list();

	@RequestMapping(value = "/user/add", method = RequestMethod.POST)
	public boolean add(User dept);
}
