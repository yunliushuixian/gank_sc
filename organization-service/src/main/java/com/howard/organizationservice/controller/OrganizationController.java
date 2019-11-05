package com.howard.organizationservice.controller;

import com.howard.organizationservice.entity.Organization;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "organization")
public class OrganizationController {

    @GetMapping(value = "/{name}")
    public Organization getOrganization(@PathVariable("name") String name) {
        //if(name.equals("a")){
        Organization organization = new Organization();
        organization.setName("a");
        organization.setContactName("contact1");
        organization.setContactNumber("1862");
        organization.setNumber("a1");
        return organization;
        //}
    }
}
