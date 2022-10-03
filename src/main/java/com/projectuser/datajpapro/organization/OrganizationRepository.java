package com.projectuser.datajpapro.organization;

import org.springframework.data.jpa.repository.JpaRepository;

import java.awt.print.Pageable;

public interface OrganizationRepository extends JpaRepository<Organization, Integer> {
    Organization findByOrganizationName(String organizationName);
}
