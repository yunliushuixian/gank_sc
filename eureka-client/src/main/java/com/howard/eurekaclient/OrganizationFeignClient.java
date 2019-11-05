package com.howard.eurekaclient;


import com.howard.eurekaclient.model.Organization;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient("organization-service")
public interface OrganizationFeignClient {
    @RequestMapping(method = RequestMethod.GET,value = "/{orgId}",consumes = "application/json")
    Organization getOrg(@PathVariable("orgId") String orgId);

}
