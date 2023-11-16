package com.step.tw.parking.services;

import com.step.tw.parking.exceptions.IllegalCapacityException;
import com.step.tw.parking.models.ParkingLot;

public interface ParkingLotService {
  ParkingLot createParkingLotOfCapacity(int capacity) throws IllegalCapacityException;
}
