package com.step.tw.predictor;

import java.util.Objects;

public class Chance {

  private final double value;

  private Chance(double value) {
    this.value = value;
  }

  public static Chance of(double value) throws InvalidChanceRangeException {
    if (value < 0 || value > 1) throw new InvalidChanceRangeException(value);
    return new Chance(value);
  }

  public Chance inverse() throws InvalidChanceRangeException {
    return Chance.of(1 - this.value);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.value);
  }

  @Override
  public boolean equals(Object anotherChance) {
    if (this == anotherChance) return true;
    if (anotherChance == null || this.getClass() != anotherChance.getClass()) return false;
    Chance chance = (Chance) anotherChance;
    return Double.compare(this.value, chance.value) == 0;
  }

  public Chance and(Chance anotherChance) throws InvalidChanceRangeException {
    return Chance.of(this.value * anotherChance.value);
  }

  public Chance or(Chance anotherChance) throws InvalidChanceRangeException {
    Chance chanceOfOccurringBoth = this.and(anotherChance);
    return Chance.of(this.value + anotherChance.value - chanceOfOccurringBoth.value);
  }
}
