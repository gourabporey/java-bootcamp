package com.step.tw.unit;

import java.util.Objects;

public class Length {
  private final double measurement;
  private final LengthUnit lengthUnit;

  private Length(double measurement, LengthUnit lengthUnit) {
    this.measurement = measurement;
    this.lengthUnit = lengthUnit;
  }

  public static Length ofFeet(double value) {
    return new Length(value, LengthUnit.FEET);
  }

  public static Length ofInch(double value) {
    return new Length(value, LengthUnit.INCH);
  }

  public static Length ofCentimeter(double value) {
    return new Length(value, LengthUnit.CENTIMETER);
  }

  public static Length ofMillimeter(double value) {
    return new Length(value, LengthUnit.MILLIMETER);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Length unit = (Length) o;
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
