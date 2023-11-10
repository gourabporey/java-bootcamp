package com.step.tw.predictor;

public class Chance {

  private final double value;

  private Chance(double value) {
    this.value = value;
  }

  public static Chance initialize(double value) throws InvalidChanceRangeException {
    if (value < 0 || value > 1) throw new InvalidChanceRangeException(value);
    return new Chance(value);
  }
}
