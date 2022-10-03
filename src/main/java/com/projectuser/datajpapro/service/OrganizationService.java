package com.projectuser.datajpapro.service;

import com.projectuser.datajpapro.entities.Organization;
import com.projectuser.datajpapro.entities.User;

import java.util.List;


public interface OrganizationService {
    public List<Organization> retrieveAllOrg();
    public Organization createOrg(Organization organization);

    public List<User> retrieveAllUsers(String organizationName);




}
