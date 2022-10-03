package com.projectuser.datajpapro.entities;
import com.projectuser.datajpapro.entities.Organization;
import lombok.Data;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@DynamicUpdate
public @Data class User {

    @Id
    @GeneratedValue
    private Integer userId;

    private String userName;

    private LocalDate birthDate;

    @ManyToOne(fetch = FetchType.EAGER)
   // @JsonIgnore
    @JoinColumn(name="organizationName")
    private Organization organization;

}








