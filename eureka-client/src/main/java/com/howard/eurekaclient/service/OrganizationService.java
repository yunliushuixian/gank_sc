package com.howard.eurekaclient.service;

import com.howard.eurekaclient.OrganizationDiscoveryClient;
import com.howard.eurekaclient.OrganizationFeignClient;
import com.howard.eurekaclient.RestClient;
import com.howard.eurekaclient.model.Organization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrganizationService {


    @Autowired
    private OrganizationDiscoveryClient organizationDiscoveryClient;

    @Autowired
    private RestClient restClient;

    @Autowired
    private OrganizationFeignClient organizationFeignClient;

    public Organization getOrganization(String organizationId, String clientType) {
        if ("discoveryClient".equals(clientType)) {
            return organizationDiscoveryClient.getOrganization("1");
        } else if ("Rest".equals(clientType)) {
            //return restClient.getOrg("1");

        } else if ("Feign".equals(clientType)) {
            return organizationFeignClient.getOrg("1");
        }
        return null;
    }


}
