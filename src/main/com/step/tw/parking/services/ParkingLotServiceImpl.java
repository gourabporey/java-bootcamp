package com.step.tw.parking.services;

import com.step.tw.parking.exceptions.IllegalCapacityException;
import com.step.tw.parking.models.ParkingLot;

import java.util.UUID;

public class ParkingLotServiceImpl implements  ParkingLotService{
  @Override
  public ParkingLot createParkingLotOfCapacity(int capacity) throws IllegalCapacityException {
    if(capacity < 0) throw new IllegalCapacityException(capacity);
    String parkingLotId = UUID.randomUUID().toString();
    return ParkingLot.ofCapacity(capacity, parkingLotId);
  }
}
