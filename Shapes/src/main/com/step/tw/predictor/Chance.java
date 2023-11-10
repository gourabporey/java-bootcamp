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

  public Chance inverse() throws InvalidChanceRangeException {
    return Chance.initialize(1 - this.value);
  }

  public boolean equals(Object another) {
    if (!(another instanceof Chance)) return false;
    return this.value == ((Chance) another).value;
  }
}
