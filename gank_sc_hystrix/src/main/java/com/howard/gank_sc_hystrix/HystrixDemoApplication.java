package com.howard.gank_sc_hystrix;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

//EnableCircuitBreaker 告诉SpringCloud 你将为你的服务使用Hystrix
//如果忘记在引导类添加@EnableCircuitBreaker注解，没有断路器将会被激活。当服务启动时，不会收到任何警告或错误消息

@SpringBootApplication
@ComponentScan(basePackages = {"com.howard.gank_sc_common.*", "com.howard.gank_sc_hystrix.*"})
public class HystrixDemoApplication {

    /*@LoadBalanced
    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }*/

    public static void main(String[] args) {
        SpringApplication.run(HystrixDemoApplication.class, args);
    }

}
