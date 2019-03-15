package cn.jbinfo.microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages= {"cn.jbinfo.microservice"})
@ComponentScan("cn.jbinfo.microservice")
public class UserConsume80_Feign_App {

    public static void main(String args[]){
        SpringApplication.run(UserConsume80_Feign_App.class,args);
    }
}
