package com.step.tw.parking.models;

import com.step.tw.parking.exceptions.IllegalCapacityException;
import com.step.tw.parking.exceptions.NoParkingLotLeftException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ParkingAttendantTest {
  private static ParkingAttendant createParkingAttendant(String name, ParkingLot... parkingLots) throws IllegalCapacityException {
    ParkingAttendant parkingAttendant = new ParkingAttendant(name);

    for (ParkingLot parkingLot : parkingLots) {
      parkingAttendant.monitorParkingLot(parkingLot);
      parkingLot.addAttendant(parkingAttendant);
      parkingLot.addIsFullObserver(parkingAttendant);
    }

    return parkingAttendant;
  }

  @Test
  void shouldParkACar() throws IllegalCapacityException, NoParkingLotLeftException {
    ParkingLot parkingLot = ParkingLot.ofCapacity(2, "abcd-01");
    ParkingAttendant gourab = createParkingAttendant("gourab", parkingLot);
    Car sourovsCar = new Car("sourov", "ka-1234");

    gourab.park(sourovsCar);

    assertTrue(parkingLot.has(sourovsCar));
  }

  @Test
  void shouldThrowNoParkingLeftExceptionWhenCapacityIsReached() throws IllegalCapacityException, NoParkingLotLeftException {
    ParkingLot parkingLot = ParkingLot.ofCapacity(2, "abcd-01");
    ParkingAttendant gourab = createParkingAttendant("gourab", parkingLot);

    Car sourovsCar = new Car("sourov", "ka-1239");
    Car milansCar = new Car("milan", "ka-1234");

    gourab.park(sourovsCar);
    gourab.park(milansCar);

    assertThrows(NoParkingLotLeftException.class, () -> gourab.park(new Car("gourab", "WB-1234")));
  }
}