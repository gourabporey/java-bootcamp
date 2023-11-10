package com.step.tw.shapes;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class SquareTest {
  @Test
  void shouldThrowAnExceptionIfSideIsLessThanZero() {
    assertThrows(InvalidDimensionException.class, () -> Square.create(-4));
  }

}
