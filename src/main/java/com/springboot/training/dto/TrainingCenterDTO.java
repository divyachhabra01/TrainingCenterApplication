package com.springboot.training.dto;

import com.springboot.training.model.Address;
import com.springboot.training.model.Course;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.validation.annotation.Validated;

import javax.validation.Valid;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.ArrayList;
import java.util.List;

@Data
@Validated
public class TrainingCenterDTO {
    @Pattern(regexp = "[A-Za-z0-9]+${12}",message = "Please enter a 12 characters alphanumeric center code!")
    private String centerCode;
    @Length(max=40, message="Please insert less than 40 characters for center name")
    @NotEmpty
    private String centerName;
    private Integer studentCapacity;
    @Valid
    @NotNull
    private Address address;
    @Pattern(regexp=".+@.+\\..+", message="Please enter a valid Email")
    private String contactEmail;
    @Digits(integer = 10,fraction = 0,message = "Please enter a valid Phone Number")
    private String contactPhone;
    private List<Course> courses = new ArrayList<>();
}
