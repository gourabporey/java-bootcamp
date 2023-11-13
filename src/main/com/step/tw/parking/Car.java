package com.step.tw.parking;

import java.util.Objects;

public class Car {
  private final String owner;
  private final String numberPlate;

  public Car(String owner, String numberPlate) {
    this.owner = owner;
    this.numberPlate = numberPlate;
  }

  public String getNumber() {
    return this.numberPlate;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Car car = (Car) o;
    return Objects.equals(owner, car.owner) && Objects.equals(numberPlate, car.numberPlate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(owner, numberPlate);
  }
}
