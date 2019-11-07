package com.howard.gank_sc_hystrix.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 注入配置中心的各种配置
 */


@Component
public class ServerConfig {

    @Value("${example.property}")
    public String comment;
}
