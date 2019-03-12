package cn.jbinfo.microservice.controller;

import cn.jbinfo.microservice.biz.User;
import cn.jbinfo.microservice.service.UserService;
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
    public User get(@PathVariable("id") String id)
    {
        return service.get(id);
    }

    @RequestMapping(value = "/user/list", method = RequestMethod.GET)
    public List<User> list()
    {
        return service.list();
    }


    @SuppressWarnings("unused")
	@RequestMapping(value = "/user/discovery", method = RequestMethod.GET)
    public Object discovery()
    {
        List<String> list = client.getServices();;;;
        List<ServiceInstance> srvList = client.getInstances("MICROSERVICE-USER");
        for (ServiceInstance element : srvList) {
            System.out.println(element.getServiceId() + "\t" + element.getHost() + "\t" + element.getPort() + "\t"
                    + element.getUri());
        }
        return this.client;
    }

}
