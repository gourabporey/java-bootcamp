package com.step.tw.parking;

public class IllegalCapacityException extends Throwable {
  public IllegalCapacityException(int capacity) {
    super(String.format("Illegal capacity %d, should be more than 0", capacity));
  }
}
