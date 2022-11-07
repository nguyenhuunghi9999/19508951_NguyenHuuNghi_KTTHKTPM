package com.nghi.PassengerService.service;

import com.nghi.PassengerService.entity.Passenger;
import com.nghi.PassengerService.repository.PassengerRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class PassengerService {

    @Autowired
    private PassengerRepository passengerRepository;

    public Passenger saveDepartment(Passenger passenger) {
        return passengerRepository.save(passenger);
    }


    public List<Passenger> getAllPassenger() {
        return passengerRepository.findAll();
    }
}
