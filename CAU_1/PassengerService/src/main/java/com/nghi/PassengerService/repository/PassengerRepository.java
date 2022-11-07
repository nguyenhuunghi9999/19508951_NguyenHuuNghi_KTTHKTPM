package com.nghi.PassengerService.repository;

import com.nghi.PassengerService.entity.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassengerRepository extends JpaRepository<Passenger, Long> {
    Passenger findByPassengerId(Long passengerId);
}
