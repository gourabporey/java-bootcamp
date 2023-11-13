package com.step.tw.parking;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class ParkingLotTest {
  @Test
  void shouldParkACar() throws ParkingLotFullException, IllegalCapacityException, NoParkingLotLeftException {
    ParkingLot parkingLot = ParkingLot.ofCapacity(5);
    List<ParkingLot> parkingLots = new ArrayList<>(List.of(parkingLot));

    ParkingAttendant gourab = new ParkingAttendant("gourab", parkingLots);
    Car sourovsCar = new Car("sourov", "KA1234");

    gourab.park(sourovsCar);

    assertTrue(parkingLot.has(sourovsCar));
  }

  @Test
  void asAnAttendantIShouldBeInformedIfTheLotIsFull() throws ParkingLotFullException, IllegalCapacityException, NoParkingLotLeftException {
    ParkingLot parkingLot = ParkingLot.ofCapacity(2);
    List<ParkingLot> parkingLots = new ArrayList<>(List.of(parkingLot));
    ParkingAttendant gourab = new ParkingAttendant("gourab", parkingLots);

    Car sourovsCar = new Car("sourov", "KA1234");
    Car gourabsCar = new Car("gourab", "WB4233");

    gourab.park(sourovsCar);
    gourab.park(gourabsCar);

    assertTrue(parkingLot.isFull());
  }

  @Test
  void asAnAttendantIShouldBeInformedIfTheLotIsNotFull() throws ParkingLotFullException, IllegalCapacityException, NoParkingLotLeftException {
    ParkingLot parkingLot = ParkingLot.ofCapacity(2);
    List<ParkingLot> parkingLots = new ArrayList<>(List.of(parkingLot));
    ParkingAttendant gourab = new ParkingAttendant("gourab", parkingLots);

    Car sourovsCar = new Car("sourov", "KA1234");

    gourab.park(sourovsCar);

    assertFalse(parkingLot.isFull());
  }

  @Test
  void shouldThrowParkingLotFullExceptionWhileTryingToParkInAFullParkingLot() throws ParkingLotFullException, IllegalCapacityException, NoParkingLotLeftException {
    ParkingLot parkingLot = ParkingLot.ofCapacity(1);
    List<ParkingLot> parkingLots = new ArrayList<>(List.of(parkingLot));
    ParkingAttendant gourab = new ParkingAttendant("gourab", parkingLots);

    Car sourovsCar = new Car("sourov", "KA1234");
    Car gourabsCar = new Car("gourab", "WB4233");

    gourab.park(sourovsCar);

    assertThrows(ParkingLotFullException.class, () -> parkingLot.park(gourabsCar));
  }
}
