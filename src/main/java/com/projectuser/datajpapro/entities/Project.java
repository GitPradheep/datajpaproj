package com.projectuser.datajpapro.entities;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data
public class Project {

    @Id
    @GeneratedValue
    private Integer projectId;
    private String projectName;


    @ManyToMany(mappedBy = "projects",fetch = FetchType.LAZY)
    @JsonIgnore
    private Set<User> users;

}