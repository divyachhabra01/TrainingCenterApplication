package com.springboot.training.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
public class Address extends BaseModel {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Integer addressId;
    @Column(name = "detailed_address")
    private String detailedAddress;

    @Column(name = "city")
    private String city;

    @Column(name = "state")
    private String state;

    @Column(name = "pin_code")
    private Integer pinCode;

}
