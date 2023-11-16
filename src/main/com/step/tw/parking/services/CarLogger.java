package com.step.tw.parking.services;

import com.step.tw.parking.models.Car;

import java.util.List;

public interface CarLogger {
  void log(Car car);
  boolean hasAll(List<Car> cars);
}
