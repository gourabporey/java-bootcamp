package com.step.tw.probability;

public class InvalidChanceRangeException extends Throwable {
  public InvalidChanceRangeException(double value) {
    super("Chance range should be between 0 to 1: Value given was " + value);
  }
}
