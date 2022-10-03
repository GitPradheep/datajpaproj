package com.projectuser.datajpapro.service;

import com.projectuser.datajpapro.organization.Organization;
import com.projectuser.datajpapro.repository.OrganizationRepository;
import com.projectuser.datajpapro.repository.UserRepository;
import com.projectuser.datajpapro.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrganizationService {

    @Autowired
    OrganizationRepository organizationRepository;

    @Autowired
    UserRepository userRepository;

    public List<Organization> retrieveAllOrg(){
        return organizationRepository.findAll();
    }

    public Organization createOrg(Organization organization){
        Organization savedOrg = organizationRepository.save(organization);
        return savedOrg;
    }

    public List<User> retrieveAllUsers(String organizationName) {
        Organization organization = organizationRepository.findByOrganizationName(organizationName);
        return userRepository.findUserByOrganization(organization);
    }


}
