package cn.jbinfo.microservice.confbean;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ConfBean {

    @Bean
    public RestTemplate getRestTemplate(){
        return  new RestTemplate();
    }
}
