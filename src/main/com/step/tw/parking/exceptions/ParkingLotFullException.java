package com.step.tw.parking.exceptions;

public class ParkingLotFullException extends Throwable {
  public ParkingLotFullException(int capacity) {
    super(String.format("Parking lot is it's full capacity of %d", capacity));
  }
}
