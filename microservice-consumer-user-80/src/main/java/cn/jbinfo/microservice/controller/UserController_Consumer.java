package cn.jbinfo.microservice.controller;


import cn.jbinfo.microservice.biz.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@EnableEurekaClient
public class UserController_Consumer {

    private static final String prefix="http://MICROSERVICE-USER";

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping(value="/consumer/user/add",method= RequestMethod.GET)
    public boolean add(User user){

        return restTemplate.postForObject(prefix+"/user/add",user,Boolean.class);
    }

    @RequestMapping(value = "/consumer/user/get/{id}")
    public User get(@PathVariable("id") String id)
    {
        return restTemplate.getForObject(prefix + "/user/get/" + id, User.class);
    }

    @SuppressWarnings("unchecked")
    @RequestMapping(value = "/consumer/user/list")
    public List<User> list()
    {

        return restTemplate.getForObject(prefix + "/user/list", List.class);
    }

    @RequestMapping(value = "/consumer/user/discovery")
    public Object discovery()
    {
        return restTemplate.getForObject(prefix + "/user/discovery", Object.class);
    }
}
