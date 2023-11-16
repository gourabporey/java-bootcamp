package com.step.tw.parking;

import com.step.tw.parking.exceptions.*;
import com.step.tw.parking.models.*;
import com.step.tw.parking.services.*;

public class Main {
  public static void main(String[] args) throws IllegalCapacityException, NoParkingLotLeftException {
    ParkingLotService parkingLotService = new ParkingLotServiceImpl();
    ParkingLot parkingLot = parkingLotService.createParkingLotOfCapacity(2);

    ParkingAttendant gourab = createParkingAttendant("gourab", parkingLot);
    ParkingAttendant milan = createParkingAttendant("milan", parkingLot);

    gourab.park(new Car("milan", "KA-5679"));
    milan.park(new Car("sourov", "KS-5679"));
  }

  private static ParkingAttendant createParkingAttendant(String name, ParkingLot... parkingLots) {
    ParkingAttendant parkingAttendant = new ParkingAttendant(name);

    for (ParkingLot parkingLot : parkingLots) {
      parkingAttendant.monitorParkingLot(parkingLot);
      parkingLot.addAttendant(parkingAttendant);
      parkingLot.addIsFullObserver(parkingAttendant);
    }

    return parkingAttendant;
  }
}
