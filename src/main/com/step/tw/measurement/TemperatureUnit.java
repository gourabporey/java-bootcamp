package com.step.tw.measurement;

public enum TemperatureUnit implements Standardizable {
  FAHRENHEIT, CELSIUS;

  @Override
  public double convertToStandard(double quantity) {
    if (this == FAHRENHEIT) return quantity;
    return (quantity * 1.8) + 32;
  }

  @Override
  public Standardizable getStandardUnit() {
    return FAHRENHEIT;
  }

  @Override
  public boolean areEqual(double quantity1, double quantity2) {
    return Math.abs(quantity1 - quantity2) < 0.1;
  }
}
