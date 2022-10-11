package com.projectuser.datajpapro.entities;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import javax.persistence.*;
import java.util.List;
@Entity
@Data
public class Organization {

    @Id
    @GeneratedValue
    private Integer organizationId;
    private String organizationName;

    @OneToMany(mappedBy = "organization")
    @JsonIgnore
    private List<User> users;

}
