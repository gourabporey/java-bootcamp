package com.step.tw.parking;

import java.util.HashMap;

public class ParkingLot {
  private final HashMap<String, Car> cars = new HashMap<>();
  private final int capacity;

  private ParkingLot(int capacity) {
    this.capacity = capacity;
  }

  public static ParkingLot ofCapacity(int capacity) throws IllegalCapacityException {
    if(capacity <= 0) throw new IllegalCapacityException(capacity);
    return new ParkingLot(capacity);
  }

  public void park(Car car) throws ParkingLotFullException {
    if(this.isFull()) throw new ParkingLotFullException(capacity);
    this.cars.put(car.getNumber(), car);
  }

  public boolean has(Car car) {
    return this.cars.containsValue(car);
  }

  public boolean isFull() {
    return this.cars.size() == this.capacity;
  }
}
