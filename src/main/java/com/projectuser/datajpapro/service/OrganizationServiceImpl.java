package com.projectuser.datajpapro.service;
import com.projectuser.datajpapro.entities.Organization;
import com.projectuser.datajpapro.exception.UserNotFoundException;
import com.projectuser.datajpapro.repository.OrganizationRepository;
import com.projectuser.datajpapro.repository.UserRepository;
import com.projectuser.datajpapro.entities.User;
import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrganizationServiceImpl implements OrganizationService {
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
    public List<User> retrieveAllUsers(int organizationId, Pageable pageable) {
        Optional<Organization> organization = organizationRepository.findById(organizationId);
        if(organization.isEmpty())
            throw new UserNotFoundException("id:"+organizationId+" "+"doesnot exists");
        return userRepository.findUserByOrganization(organization,pageable);

    }

}
