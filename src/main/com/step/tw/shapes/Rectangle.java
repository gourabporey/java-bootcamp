package com.step.tw.shapes;

public class Rectangle {
  private final double length;
  private final double breadth;

  private Rectangle(double length, double breadth) {
    this.length = length;
    this.breadth = breadth;
  }

  public static Rectangle create(double length, double breadth) throws InvalidDimensionException {
    boolean isLengthValid = isValid(length);
    boolean isBreadthValid = isValid(breadth);

    if (!isLengthValid || !isBreadthValid) throw new InvalidDimensionException();

    return new Rectangle(length, breadth);
  }

  private static boolean isValid(double side) {
    return side >= 0;
  }

  public static Rectangle create(double side) throws InvalidDimensionException {
    return Rectangle.create(side, side);
  }

  public double area() {
    return this.length * this.breadth;
  }

  public double perimeter() {
    return 2 * (this.length + this.breadth);
  }
}
