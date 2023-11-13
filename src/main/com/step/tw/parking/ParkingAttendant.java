package com.step.tw.parking;

import java.util.List;

public class ParkingAttendant {
  private final String attendantName;
  private final List<ParkingLot> parkingLots;

  public ParkingAttendant(String attendantName, List<ParkingLot> parkingLots) {
    this.attendantName = attendantName;
    this.parkingLots = parkingLots;
  }

  public void park(Car car) throws ParkingLotFullException, NoParkingLotLeftException {
    for(ParkingLot parkingLot: this.parkingLots) {
      if(!parkingLot.isFull()) {
        parkingLot.park(car);
        return;
      }
    }

    throw new NoParkingLotLeftException();
  }
}
