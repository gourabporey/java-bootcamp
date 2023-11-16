package com.step.tw.parking.models;

import com.step.tw.parking.exceptions.NoParkingLotLeftException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ParkingAttendant implements IsFullObserver {
  private final String attendantName;
  private final List<ParkingLot> parkingLots;

  public ParkingAttendant(String attendantName) {
    this.attendantName = attendantName;
    this.parkingLots = new ArrayList<>();
  }

  public void monitorParkingLot(ParkingLot parkingLot) {
    this.parkingLots.add(parkingLot);
  }

  public void park(Car car) throws NoParkingLotLeftException {
    ParkingLot parkingLotWithEmptySpace = null;

    for (ParkingLot parkingLot : this.parkingLots) {
      if(!parkingLot.isFull()) {
        parkingLotWithEmptySpace = parkingLot;
        break;
      }
    }

    if(parkingLotWithEmptySpace == null) throw new NoParkingLotLeftException();
    parkingLotWithEmptySpace.park(car);
  }

  public void assign(ParkingAssistant parkingAssistant) {
    parkingAssistant.monitor(parkingLots);
  }

  @Override
  public void informIsFull(String id) {
    System.out.printf("parking lot %s is full%n", id);
  }

  public String getAttendantName() {
    return attendantName;
  }

  @Override
  public String getName() {
    return getAttendantName();
  }
}
