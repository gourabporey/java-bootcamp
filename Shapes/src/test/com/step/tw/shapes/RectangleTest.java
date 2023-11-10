package com.step.tw.shapes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RectangleTest {
  @Test
  void shouldCalculateTheAreaOfARectangle() {
    Rectangle rectangle = Rectangle.create(1, 2);
    assertEquals(2, rectangle.area());
  }

  @Test
  void areaShouldBeZeroForNoLengthOrBreadth() {
    Rectangle rectangle = Rectangle.create(1, 0);
    assertEquals(0, rectangle.area());
  }

  @Test
  void shouldCalculateThePerimeterOfARectangle() {
    Rectangle rectangle = Rectangle.create(2, 3);
    assertEquals(10, rectangle.perimeter());
  }
}
