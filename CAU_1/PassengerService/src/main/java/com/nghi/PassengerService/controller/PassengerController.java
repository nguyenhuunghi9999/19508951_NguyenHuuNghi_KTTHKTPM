package com.nghi.PassengerService.controller;

import com.nghi.PassengerService.entity.Passenger;
import com.nghi.PassengerService.service.PassengerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/passenger")
@Slf4j
public class PassengerController {

    @Autowired
    private PassengerService passengerService;

    @PostMapping("/")
    public Passenger saveDepartment(@RequestBody Passenger department) {
        return  passengerService.savePassenger(department);
    }

    //API getALL
    @GetMapping("/list")
    public List<Passenger> getAllPassenger(){
        return passengerService.getAllPassenger();
    }

    @GetMapping("/{id}")
    public Passenger findPassengerById(@PathVariable("id") Long passenderId) {
        return passengerService.findPassengerById(passenderId);
    }
}
