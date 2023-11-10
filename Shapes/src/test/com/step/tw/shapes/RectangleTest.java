package com.step.tw.shapes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class RectangleTest {
  @Test
  void shouldCalculateTheAreaOfARectangle() throws InvalidDimensionException {
    Rectangle rectangle = Rectangle.create(1, 2);
    assertEquals(2, rectangle.area());
  }

  @Test
  void shouldThrowAnExceptionForLengthLessThanZero() {
    assertThrows(InvalidDimensionException.class, () -> Rectangle.create(-5, 6));
  }

  @Test
  void shouldThrowAnExceptionForBreadthLessThanZero() {
    assertThrows(InvalidDimensionException.class, () -> Rectangle.create(5, -6));
  }

  @Test
  void areaShouldBeZeroForNoLengthOrBreadth() throws InvalidDimensionException {
    Rectangle rectangle = Rectangle.create(1, 0);
    assertEquals(0, rectangle.area());
  }

  @Test
  void shouldCalculateThePerimeterOfARectangle() throws InvalidDimensionException {
    Rectangle rectangle = Rectangle.create(2, 3);
    assertEquals(10, rectangle.perimeter());
  }

  @Test
  void areaShouldBeTheSquareOfSideForASquare() throws InvalidDimensionException {
    Rectangle square = Rectangle.create(5);
    assertEquals(25, square.area());
  }
}
