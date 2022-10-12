package com.projectuser.datajpapro.controller;
import com.projectuser.datajpapro.entities.Organization;
import com.projectuser.datajpapro.service.OrganizationService;
import com.projectuser.datajpapro.entities.User;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/organizations")
public class OrganizationController {
    @Autowired
    OrganizationService organizationService;
    @GetMapping("/")
    public List<Organization> retrieveAllOrg(){
        return organizationService.retrieveAllOrg();
    }
    @PostMapping("/")
    public Organization createOrg(@RequestBody Organization organization){
        return organizationService.createOrg(organization);
    }
    @GetMapping("/{organizationId}/users")
    public List<User> retrieveAllUsers(@PathVariable int organizationId, Pageable pageable) {
        return organizationService.retrieveAllUsers(organizationId,pageable);
    }
}