package com.projectuser.datajpapro.repository;

import com.projectuser.datajpapro.organization.Organization;
import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Pageable;

public interface OrganizationRepository extends JpaRepository<Organization, Integer> {
    Organization findByOrganizationName(String organizationName);
}
