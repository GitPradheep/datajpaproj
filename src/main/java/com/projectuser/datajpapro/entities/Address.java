package com.projectuser.datajpapro.entities;
import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Address {

    @Id
    @GeneratedValue
    private Integer addressId;
    private String city;
    private String addressType;


}
