package com.howard.eurekaclient;

import com.howard.eurekaclient.model.Organization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Component
public class OrganizationDiscoveryClient {

    /**
     * 没有利用Ribbon的客户端负载均衡---尽管通过直接调用DiscoveryClient可以获得服务列表，但是要调用哪些返回的服务实例成了开发者的责任
     * 开发人员做了太多的工作---构建调用服务的url.
     * 直接实例化了RestTemplate类。应该利用Spring框架进行注入。
     */
    @Autowired
    private DiscoveryClient discoveryClient;

    public Organization getOrganization(String organizationId)
    {
        RestTemplate restTemplate = new RestTemplate();
        //获取组织服务的所有实例的列表，检索要调用的服务端点
        List<ServiceInstance> instances = discoveryClient.getInstances("organization-service");
        if(instances.size() ==0) return null;
        String serviceUrl = String.format("%s/%s",instances.get(0).getUri().toString(),organizationId);
        //使用标准的Spring REST模板类去调用服务
        ResponseEntity<Organization> restExchange = restTemplate.exchange(serviceUrl, HttpMethod.GET,null,Organization.class,organizationId);
        return restExchange.getBody();
    }

}
