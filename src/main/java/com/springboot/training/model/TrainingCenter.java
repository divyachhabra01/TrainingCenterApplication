package com.springboot.training.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
public class TrainingCenter extends BaseModel{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "code")
    private String centerCode;


    @Column(name = "name")
    private String centerName;

    @Column(name = "student_capacity")
    private Integer studentCapacity;

    @OneToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER, targetEntity = Address.class)
    private Address address;

    @Column(name = "contact_email")
    private String contactEmail;

    @Column(name = "contact_phone")
    private String contactPhone;

    @OneToMany(mappedBy = "trainingCenter", cascade = CascadeType.ALL,fetch =FetchType.EAGER,targetEntity = Course.class)
    private List<Course> courses;

}
