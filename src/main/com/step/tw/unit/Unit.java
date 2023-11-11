package com.step.tw.unit;

import java.util.Objects;

public class Unit {
  private final double measurement;
  private final Measurable lengthUnit;

  private Unit(double measurement, Measurable lengthUnit) {
    this.measurement = measurement;
    this.lengthUnit = lengthUnit;
  }

  public static Unit of(double measurement, Measurable lengthUnit) {
    return new Unit(measurement, lengthUnit);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Unit unit = (Unit) o;
    return Math.abs(this.convertToStandard() - unit.convertToStandard()) < 1;
  }

  private double convertToStandard() {
    return this.lengthUnit.convertToStandard(this.measurement);
  }

  @Override
  public String toString() {
    return "Length{" +
        "measurement=" + measurement +
        ", lengthUnit=" + lengthUnit +
        '}';
  }

  @Override
  public int hashCode() {
    return Objects.hash(measurement);
  }
}
