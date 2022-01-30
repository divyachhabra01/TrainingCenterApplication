package com.springboot.training.service;

import com.springboot.training.dto.TrainingCenterDTO;
import com.springboot.training.model.TrainingCenter;

import java.util.List;

public interface TrainingCenterService {
    void addCenter(TrainingCenter trainingCenter);
    List<TrainingCenter> getAllCenters();
}
