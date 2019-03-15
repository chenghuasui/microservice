package cn.jbinfo.microservice.controller;


import cn.jbinfo.microservice.biz.user.domain.User;
import cn.jbinfo.microservice.biz.user.service.UserClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@EnableEurekaClient
public class UserController_Consumer {

    @Autowired
    public UserClientService userClientService;

    @RequestMapping(value = "/consumer/user/get/{id}")
    public User get(@PathVariable("id") String id)
    {
        return this.userClientService.get(id);
    }

    @RequestMapping(value = "/consumer/user/list")
    public List<User> list()
    {
        return this.userClientService.list();
    }

    @RequestMapping(value = "/consumer/user/add")
    public Object add(User user)
    {
        return this.userClientService.add(user);
    }
}
