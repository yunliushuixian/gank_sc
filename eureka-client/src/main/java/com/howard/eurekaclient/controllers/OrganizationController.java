package com.howard.eurekaclient.controllers;

import com.howard.eurekaclient.model.Organization;
import com.howard.eurekaclient.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "organization")
public class OrganizationController {

    @Autowired
    private OrganizationService organizationService;

    @GetMapping(value = "/{organizationId}/{clientType}")
    public Organization getOrganization(@PathVariable("organizationId") String organizationId,@PathVariable("clientType") String clientType){


        Organization organization = organizationService.getOrganization(organizationId,clientType);
        return organization;

    }

}
