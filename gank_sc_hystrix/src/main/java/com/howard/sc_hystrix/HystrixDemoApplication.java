package com.howard.sc_hystrix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

//EnableCircuitBreaker 告诉SpringCloud 你将为你的服务使用Hystrix
//如果忘记在引导类添加@EnableCircuitBreaker注解，没有断路器将会被激活。当服务启动时，不会收到任何警告或错误消息

@SpringBootApplication
@EnableEurekaClient
@EnableCircuitBreaker
public class HystrixDemoApplication {

    @LoadBalanced
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(HystrixDemoApplication.class, args);
    }

}
