package com.projectuser.datajpapro.controller;

import com.projectuser.datajpapro.entities.Organization;
import com.projectuser.datajpapro.service.OrganizationService;
import com.projectuser.datajpapro.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrganizationController {


    @Autowired
    OrganizationService organizationService;

    @GetMapping("/org")
    public List<Organization> retrieveAllOrg(){
        return organizationService.retrieveAllOrg();
    }

    @PostMapping("/org")
    public Organization createOrg(@RequestBody Organization organization){
        return organizationService.createOrg(organization);
    }
    @GetMapping("/usersbyorg/{organizationName}")
    public List<User> retrieveAllUsers(@PathVariable String organizationName) {
        return organizationService.retrieveAllUsers(organizationName);
    }
}
