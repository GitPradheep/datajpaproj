package com.projectuser.datajpapro.user;

import com.projectuser.datajpapro.organization.Organization;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Integer> {
    List<User> findUserByOrganization(Organization organization);





}
