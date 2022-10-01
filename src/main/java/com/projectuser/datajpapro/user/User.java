package com.projectuser.datajpapro.user;
import com.fasterxml.jackson.annotation.JsonIgnore;
//import com.projectuser.datajpapro.organization.Organization;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@DynamicUpdate
public @Data class User {

    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    private LocalDate birthDate;

//    @OneToOne
//    @JsonIgnore
//    public List<Organization> org;

}








