package com.step.tw.shapes;

public class Rectangle {
  private final int length;
  private final int breadth;

  private Rectangle(int length, int breadth) {
    this.length = length;
    this.breadth = breadth;
  }

  public static Rectangle create(int length, int breadth) throws InvalidDimensionException {
    boolean isLengthValid = length >= 0;
    boolean isBreadthValid = breadth >= 0;

    if (!isLengthValid || !isBreadthValid) throw new InvalidDimensionException();
    
    return new Rectangle(length, breadth);
  }

  public int area() {
    return this.length * this.breadth;
  }

  public int perimeter() {
    return 2 * (this.length + this.breadth);
  }

}
