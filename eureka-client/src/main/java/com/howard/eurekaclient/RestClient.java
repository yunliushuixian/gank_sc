package com.howard.eurekaclient;

import com.howard.eurekaclient.model.Organization;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class RestClient {

    /*@Autowired
    private RestTemplate restTemplate;

    public Organization getOrg(String organizationId){
        ResponseEntity<Organization> restExchange =
                restTemplate.exchange("http://organization-service/{orgId}",
                        HttpMethod.GET,
                        null,
                        Organization.class,
                        organizationId);

        return restExchange.getBody();
    }*/


}
