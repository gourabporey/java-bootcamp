package com.step.tw.measurement;

import java.util.Objects;

public class Measure<U extends Standardizable> {
  private final double quantity;
  private final U unit;

  public Measure(double quantity, U unit) {
    this.quantity = quantity;
    this.unit = unit;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Measure<U> measure = (Measure<U>) o;
    return isOfSameType(measure) && isQuantityEqual(measure);
  }

  private boolean isQuantityEqual(Measure<U> measure) {
    double thisInStandard = this.convertToStandardQuantity();
    double otherInStandard = measure.convertToStandardQuantity();

    return this.unit.areEqual(thisInStandard, otherInStandard);
  }

  @Override
  public int hashCode() {
    return Objects.hash(quantity, unit);
  }

  private boolean isOfSameType(Measure<U> measure) {
    Standardizable thisStandardUnit = this.unit.getStandardUnit();
    Standardizable otherStandardUnit = measure.unit.getStandardUnit();

    return thisStandardUnit == otherStandardUnit;
  }

  private double convertToStandardQuantity() {
    return this.unit.convertToStandard(this.quantity);
  }

  @Override
  public String toString() {
    return "Measure{" +
        "quantity=" + quantity +
        ", unit=" + unit +
        '}';
  }

  public Measure<U> add(Measure<U> other) {
    double thisToStandard = this.convertToStandardQuantity();
    double otherToStandard = other.convertToStandardQuantity();
    U standard = (U) this.unit.getStandardUnit();

    return new Measure<>(thisToStandard + otherToStandard, standard);
  }
}