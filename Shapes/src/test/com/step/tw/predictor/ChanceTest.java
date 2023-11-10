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

  @Test
  void shouldComputeChanceOfOccurringTwoIndependentEventSimultaneously() throws InvalidChanceRangeException {
    Chance chance1 = Chance.initialize(0.5);
    Chance chance2 = Chance.initialize(0.5);
    assertEquals(chance1.and(chance2), Chance.initialize(0.25));
  }
}
