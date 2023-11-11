package com.step.tw.unit;

import java.util.Objects;

public class Unit {
  private final double value;

  public Unit(double value) {
    this.value = value;
  }

  public boolean isGreater(Unit otherUnit) {
    return this.value > otherUnit.value;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Unit unit = (Unit) o;
    return Double.compare(value, unit.value) == 0;
  }

  @Override
  public int hashCode() {
    return Objects.hash(value);
  }
}
