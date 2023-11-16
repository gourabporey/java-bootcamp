package com.step.tw.parking.models;

import com.step.tw.parking.services.CarLogger;

import java.util.List;

public class ParkingAssistant {
  private final String name;
  private final CarLogger carLogger;
  private List<ParkingLot> parkingLots;

  public ParkingAssistant(String name, CarLogger carLogger) {
    this.name = name;
    this.carLogger = carLogger;
  }

  public void monitor(List<ParkingLot> parkingLots) {
    this.parkingLots = parkingLots;
  }

  public void displayAllCars() {

  }
}
