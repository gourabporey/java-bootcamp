package com.step.tw.measurement;

public interface Standardizable {
  double convertToStandard(double quantity);
  Standardizable getStandardUnit();
  boolean areEqual(double quantity1, double quantity2);
}
