package com.springboot.training.service.Impl;

import com.springboot.training.exception.AddressNotFoundException;
import com.springboot.training.exception.InternalServerError;
import com.springboot.training.model.Course;
import com.springboot.training.model.TrainingCenter;
import com.springboot.training.repository.TrainingCenterRepository;
import com.springboot.training.service.TrainingCenterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
@Slf4j
public class TrainingCenterServiceImpl implements TrainingCenterService {

    @Autowired
    private TrainingCenterRepository trainingCenterRepository;

    @Override
    public List<TrainingCenter> getAllCenters() {

        List<TrainingCenter> centers;
        centers = trainingCenterRepository.findAll();
        return  centers;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void addCenter(TrainingCenter trainingCenter) {
                validateBeforeAdding(trainingCenter);
        for(Course course :trainingCenter.getCourses())
            course.setTrainingCenter(trainingCenter);
        try {
            trainingCenterRepository.saveAndFlush(trainingCenter);
        } catch (Exception e) {
            log.error("Getting Internal Server Error due to {} ",Arrays.toString(e.getStackTrace()));
            throw InternalServerError.builder().message("Getting Internal Server Error due to "+ Arrays.toString(e.getStackTrace())).build();
        }
    }

    public void validateBeforeAdding(TrainingCenter trainingCenter) {
        if (trainingCenter.getAddress() == null) {
            log.error("address not found for center name: {}", trainingCenter.getCenterName());
            throw AddressNotFoundException.builder().message("Address Not found, This field can not be empty").build();
        }
    }
}