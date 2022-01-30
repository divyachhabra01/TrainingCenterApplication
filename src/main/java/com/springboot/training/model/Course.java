package com.springboot.training.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
@Entity
public class Course extends BaseModel{

    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Integer courseId;

    @ManyToOne
    @JoinColumn(name = "training_center_id")
    @JsonIgnore
    private TrainingCenter trainingCenter;

    @Column(name = "course")
    private String courseName;

    public void setTrainingCenter(TrainingCenter trainingCenter) {
        this.trainingCenter = trainingCenter;
    }

}
