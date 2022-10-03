package com.projectuser.datajpapro.organization;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.projectuser.datajpapro.user.User;
import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
public @Data class Organization {

    @Id
    @GeneratedValue
    private Integer orgId;

    private String organizationName;

    @OneToMany(mappedBy = "organization")
    @JsonIgnore
    private List<User> users;

}
