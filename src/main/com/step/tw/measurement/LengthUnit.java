package com.step.tw.measurement;

public enum LengthUnit implements Standardizable {
  INCH(25.4),
  CENTIMETER(10),
  FEET(304.8),
  MILLIMETER(1);

  private final double conversionFactor;
  private static final double errorTolerance = 0.05;

  LengthUnit(double conversionFactor) {
    this.conversionFactor = conversionFactor;
  }

  public double convertToStandard(double quantity) {
    return this.conversionFactor * quantity / 25.4;
  }

  public LengthUnit getStandardUnit(){
    return INCH;
  }

  public boolean areEqual(double quantity1, double quantity2) {
    return Math.abs(quantity1 - quantity2) < errorTolerance;
  }
}
