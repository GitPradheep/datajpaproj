package com.projectuser.datajpapro.repository;

import com.projectuser.datajpapro.entities.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepository extends JpaRepository<Project,Integer> {
    Project findByProjectName(String string);



}
