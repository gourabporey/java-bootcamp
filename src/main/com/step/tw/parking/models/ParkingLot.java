package com.step.tw.parking.models;

import com.step.tw.parking.exceptions.IllegalCapacityException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ParkingLot {
  private final HashMap<String, Car> cars = new HashMap<>();
  private final String id;
  private final int capacity;
  private final List<ParkingAttendant> attendants = new ArrayList<>();
  private final HashMap<ParkingEvent, List<? extends Observer>> subscribers;

  private ParkingLot(String id, int capacity) {
    this.id = id;
    this.capacity = capacity;
    this.subscribers = new HashMap<>();
  }

  public static ParkingLot ofCapacity(int capacity, String parkingLotId) throws IllegalCapacityException {
    if(capacity <= 0) throw new IllegalCapacityException(capacity);
    return new ParkingLot(parkingLotId, capacity);
  }

  public void addIsFullObserver(IsFullObserver isFullObserver) {
    List<IsFullObserver> isFullObservers = getIsFullListeners();
    isFullObservers.add(isFullObserver);
  }

  private List<IsFullObserver> getIsFullListeners() {
    List<IsFullObserver> isFullObservers = (List<IsFullObserver>) this.subscribers.getOrDefault(ParkingEvent.IS_FULL, new ArrayList<>());
    this.subscribers.put(ParkingEvent.IS_FULL, isFullObservers);
    return isFullObservers;
  }

  public void park(Car car) {
    this.cars.put(car.getNumber(), car);

    if(this.isFull()) {
      List<IsFullObserver> isFullObservers = getIsFullListeners();
      isFullObservers.forEach(isFullObserver -> {
        isFullObserver.informIsFull(this.id);
        System.out.printf("Informed %s\n", isFullObserver.getName());
      });
    }
  }

  public boolean has(Car car) {
    return this.cars.containsValue(car);
  }

  public boolean isFull() {
    return this.cars.size() == this.capacity;
  }

  public void addAttendant(ParkingAttendant parkingAttendant) {
    this.attendants.add(parkingAttendant);
  }
}
