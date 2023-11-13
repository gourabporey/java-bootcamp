package com.step.tw.parking;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ParkingLotTest {
  @Test
  void shouldParkACar() throws ParkingLotFullException, IllegalCapacityException {
    ParkingLot parkingLot = ParkingLot.ofCapacity(5);
    Car sourovsCar = new Car("sourov", "KA1234");

    parkingLot.park(sourovsCar);

    assertTrue(parkingLot.has(sourovsCar));
  }

  @Test
  void asAnAttendantIShouldBeInformedIfTheLotIsFull() throws ParkingLotFullException, IllegalCapacityException {
    ParkingLot parkingLot = ParkingLot.ofCapacity(2);
    Car sourovsCar = new Car("sourov", "KA1234");
    Car gourabsCar = new Car("gourab", "WB4233");

    parkingLot.park(sourovsCar);
    parkingLot.park(gourabsCar);

    assertTrue(parkingLot.isFull());
  }

  @Test
  void asAnAttendantIShouldBeInformedIfTheLotIsNotFull() throws ParkingLotFullException, IllegalCapacityException {
    ParkingLot parkingLot = ParkingLot.ofCapacity(2);
    Car sourovsCar = new Car("sourov", "KA1234");

    parkingLot.park(sourovsCar);

    assertFalse(parkingLot.isFull());
  }

  @Test
  void shouldThrowParkingLotFullExceptionWhileTryingToParkInAFullParkingLot() throws ParkingLotFullException, IllegalCapacityException {
    ParkingLot parkingLot = ParkingLot.ofCapacity(1);
    Car sourovsCar = new Car("sourov", "KA1234");
    Car gourabsCar = new Car("gourab", "WB4233");

    parkingLot.park(sourovsCar);

    assertThrows(ParkingLotFullException.class, () -> parkingLot.park(gourabsCar));
  }
}
