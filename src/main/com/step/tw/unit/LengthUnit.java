package com.step.tw.unit;

public enum LengthUnit {
  INCH(25.4),
  CENTIMETER(10),
  FEET(304.8),
  MILLIMETER(1);

  private final double conversionFactor;

  private LengthUnit(double conversionFactor) {
    this.conversionFactor = conversionFactor;
  }

  public double convertToStandard(double measurement) {
    return this.conversionFactor * measurement;
  }
}
