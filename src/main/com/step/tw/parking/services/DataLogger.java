package com.step.tw.parking.services;

import com.step.tw.parking.models.Car;

import java.util.ArrayList;
import java.util.List;

public class DataLogger implements CarLogger {
  private final List<Car> cars = new ArrayList<>();
  @Override
  public void log(Car car) {
    this.cars.add(car);
  }

  @Override
  public boolean hasAll(List<Car> cars) {
    return this.cars.containsAll(cars);
  }
}
