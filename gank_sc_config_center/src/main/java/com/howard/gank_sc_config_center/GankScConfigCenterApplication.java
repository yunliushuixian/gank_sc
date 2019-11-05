package com.howard.gank_sc_config_center;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class GankScConfigCenterApplication {

    public static void main(String[] args) {
        SpringApplication.run(GankScConfigCenterApplication.class, args);
    }

}
