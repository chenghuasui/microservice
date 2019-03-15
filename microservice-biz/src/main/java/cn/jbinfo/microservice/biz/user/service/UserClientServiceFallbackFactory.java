package cn.jbinfo.microservice.biz.user.service;

import cn.jbinfo.microservice.biz.user.domain.User;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;

@Component // 不要忘记添加，不要忘记添加
public class UserClientServiceFallbackFactory implements FallbackFactory<UserClientService>
{
	@Override
	public UserClientService create(Throwable throwable)
	{
		return new UserClientService() {
			@Override
			public User get(String id)
			{
				return new User().setId(id).setUserName("1111111111111111111111111111111该ID：" + id + "没有没有对应的信息,null--@HystrixCommand")
						.setDbSource("no this database in MySQL");
//				return this.get(id);
			}

			@Override
			public List<User> list()
			{
				return this.list();
			}

			@Override
			public boolean add(User user)
			{
				return this.add(user);
			}
		};
	}
}
