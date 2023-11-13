package com.step.tw.measurement;

public enum VolumeUnit implements Standardizable {
  LITER(1),
  GALLON(3.78);

  private final double conversionFactor;
  private final double errorTolerance = 0.1;

  VolumeUnit(double conversionFactor) {
    this.conversionFactor = conversionFactor;
  }

  @Override
  public double convertToStandard(double quantity) {
    return this.conversionFactor * quantity;
  }

  public VolumeUnit getStandardUnit() {
    return LITER;
  }

  @Override
  public boolean areEqual(double quantity1, double quantity2) {
    return Math.abs(quantity1 - quantity2) < errorTolerance;
  }
}
