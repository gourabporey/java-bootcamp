package com.step.tw.unit;

public enum VolumeUnit implements Measurable {
  LITER(1),
  GALLON(3.78);

  private final double conversionFactor;

  private VolumeUnit(double conversionFactor) {
    this.conversionFactor = conversionFactor;
  }

  @Override
  public double convertToStandard(double measurement) {
    return this.conversionFactor * measurement;
  }
}
