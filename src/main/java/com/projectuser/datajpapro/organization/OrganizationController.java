package com.projectuser.datajpapro.organization;

import com.projectuser.datajpapro.user.User;
import com.projectuser.datajpapro.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrganizationController {

    @Autowired
    OrganizationRepository organizationRepository;

    @Autowired
    UserRepository repository;

    @GetMapping("/org")
    public List<Organization> retrieveAllOrg(){
        return organizationRepository.findAll();
    }

    @PostMapping("/org")
    public Organization createOrg(@RequestBody Organization organization){
        Organization savedOrg = organizationRepository.save(organization);
        return savedOrg;
    }
    @GetMapping("/usersbyorg/{organizationName}")
    public List<User> retrieveAllUsers(@PathVariable String organizationName) {
        Organization organization = organizationRepository.findByOrganizationName(organizationName);
        return repository.findUserByOrganization(organization);
    }
}
