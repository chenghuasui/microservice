package cn.jbinfo.microservice.controller;

import cn.jbinfo.microservice.biz.user.domain.User;
import cn.jbinfo.microservice.service.UserService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class UserController
{

    @Autowired
    private UserService service;

    @Autowired
    private DiscoveryClient client;

    @RequestMapping(value = "/user/add", method = RequestMethod.POST)
    public boolean add(@RequestBody User dept)
    {

        return service.add(dept);
    }

    @RequestMapping(value = "/user/get/{id}", method = RequestMethod.GET)
    //一旦调用服务方法失败并抛出了错误信息后，会自动调用@HystrixCommand标注好的fallbackMethod调用类中的指定方法
    @HystrixCommand(fallbackMethod = "processHystrix_Get")
    public User get(@PathVariable("id") String id)
    {
        User user = this.service.get(id);
        if (null == user) {
            throw new RuntimeException("该ID：" + id + "没有没有对应的信息");
        }
        return user;
    }

    @RequestMapping(value = "/user/list", method = RequestMethod.GET)
    public List<User> list()
    {
        return service.list();
    }

    public User processHystrix_Get(@PathVariable("id") String id)
    {
        return new User().setId(id).setUserName("该ID：" + id + "没有没有对应的信息,null--@HystrixCommand")
                .setDbSource("no this database in MySQL");
    }



}
