package com.projectuser.datajpapro.entities;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
public @Data class Project {

    @Id
    @GeneratedValue
    private Integer projectId;
    private String projectName;

    @ManyToMany(mappedBy = "projects",fetch = FetchType.LAZY)
    private Set<User> users;

}