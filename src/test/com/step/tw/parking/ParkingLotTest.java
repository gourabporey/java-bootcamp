package com.step.tw.parking;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ParkingLotTest {
  @Test
  void shouldParkACar() {
    ParkingLot parkingLot = new ParkingLot(5);
    Car sourovsCar = new Car("sourov", "KA1234");

    parkingLot.park(sourovsCar);

    assertTrue(parkingLot.has(sourovsCar));
  }

  @Test
  void asAnAttendantIShouldBeInformedIfTheLotIsFull() {
    ParkingLot parkingLot = new ParkingLot(2);
    Car sourovsCar = new Car("sourov", "KA1234");
    Car gourabsCar = new Car("gourab", "WB4233");

    parkingLot.park(sourovsCar);
    parkingLot.park(gourabsCar);

    assertTrue(parkingLot.isFull());
  }

  @Test
  void asAnAttendantIShouldBeInformedIfTheLotIsNotFull() {
    ParkingLot parkingLot = new ParkingLot(2);
    Car sourovsCar = new Car("sourov", "KA1234");

    parkingLot.park(sourovsCar);

    assertFalse(parkingLot.isFull());
  }
}
