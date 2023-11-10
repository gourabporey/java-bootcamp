package com.step.tw.predictor;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ChanceTest {
  @Test
  public void shouldThrowAnExceptionForChanceBeingLessThanZero() {
    assertThrows(InvalidChanceRangeException.class, () -> Chance.initialize(-0.1));
  }

  @Test
  public void shouldThrowAnExceptionForChanceBeingGreaterThanOne() {
    assertThrows(InvalidChanceRangeException.class, () -> Chance.initialize(1.1));
  }

  @Test
  void shouldCalculateTheInverseOfAChanceOfAnEvent() throws InvalidChanceRangeException {
    Chance chance = Chance.initialize(0.4);
    assertEquals(chance.inverse(), Chance.initialize(0.6));
  }
}
