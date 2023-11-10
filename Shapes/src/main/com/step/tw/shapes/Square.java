package com.step.tw.shapes;

public class Square {
  private final int side;

  private Square(int side) {
    this.side = side;
  }

  public static Square create(int side) throws InvalidDimensionException {
    if (side < 0) throw new InvalidDimensionException();
    return new Square(side);
  }
}
