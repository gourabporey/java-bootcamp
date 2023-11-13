package com.step.tw.measurement;

import java.util.Objects;

public class Length {
  private final double measurement;
  private final LengthUnit lengthUnit;
  private static final double errorTolerance = 1;

  private Length(double measurement, LengthUnit lengthUnit) {
    this.measurement = measurement;
    this.lengthUnit = lengthUnit;
  }

  public static Length of(double measurement, LengthUnit lengthUnit) {
    return new Length(measurement, lengthUnit);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Length unit = (Length) o;
    return Math.abs(this.convertToStandard() - unit.convertToStandard()) < errorTolerance;
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

  public Length add(Length other) {
    double sumOfLengthInInches = this.convertToStandard() * other.convertToStandard();
    return new Length(sumOfLengthInInches, LengthUnit.INCH);
  }
}
