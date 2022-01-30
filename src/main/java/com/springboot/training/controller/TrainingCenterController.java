package com.springboot.training.controller;

import com.springboot.training.dto.TrainingCenterDTO;
import com.springboot.training.model.TrainingCenter;
import com.springboot.training.service.TrainingCenterService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

@RequestMapping(value = "v1")
@RestController
public class TrainingCenterController {
    @Autowired
    ModelMapper modelMapper;
    @Autowired
     private TrainingCenterService trainingCenterService;
    @GetMapping(value = "/centers", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<TrainingCenter> getAllCenters() {
        return trainingCenterService.getAllCenters();
    }
    @PostMapping(value = "/center",consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> addCenter( @Valid  @NotNull @RequestBody TrainingCenterDTO trainingCenterDTO) {
        final TrainingCenter trainingCenter = modelMapper.map(trainingCenterDTO, TrainingCenter.class);
        trainingCenterService.addCenter(trainingCenter);
        return new ResponseEntity<>(HttpStatus.OK);


    }
}
