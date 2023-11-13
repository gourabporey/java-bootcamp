package com.step.tw.measurement;

import java.util.function.Function;

public enum TemperatureUnit implements Standardizable {
  FAHRENHEIT(a -> a),
  CELSIUS(a -> a * 1.8 + 32);

  private final Function<Double, Double> converter;
  private static final double delta = 0.1;

  TemperatureUnit(Function<Double, Double> converter) {
    this.converter = converter;
  }

  @Override
  public double convertToStandard(double quantity) {
    return this.converter.apply(quantity);
  }

  @Override
  public Standardizable getStandardUnit() {
    return FAHRENHEIT;
  }

  @Override
  public boolean areEqual(double quantity1, double quantity2) {
    return Math.abs(quantity1 - quantity2) < delta;
  }
}
