package com.step.tw.probability;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ChanceTest {
  @Test
  public void shouldThrowAnExceptionForChanceBeingLessThanZero() {
    assertThrows(InvalidChanceRangeException.class, () -> Chance.of(-0.1));
  }

  @Test
  public void shouldThrowAnExceptionForChanceBeingGreaterThanOne() {
    assertThrows(InvalidChanceRangeException.class, () -> Chance.of(1.1));
  }

  @Test
  void shouldCalculateTheInverseOfAChanceOfAnEvent() throws InvalidChanceRangeException {
    Chance chanceOfGettingTail = Chance.of(0.4);
    assertEquals(chanceOfGettingTail.inverse(), Chance.of(0.6));
  }

  @Test
  void shouldComputeChanceOfOccurringTwoEventsSimultaneously() throws InvalidChanceRangeException {
    Chance chanceOfGettingTail = Chance.of(0.5);
    Chance chanceOfGettingBothTails = Chance.of(0.25);

    assertEquals(chanceOfGettingTail.and(chanceOfGettingTail), chanceOfGettingBothTails);
  }

  void shouldComputeChanceThatAtLeastOneEventWillOccur() throws InvalidChanceRangeException {
    Chance chanceOfGettingTailInCoin1 = Chance.of(0.5);
    Chance chanceOfGettingTailInCoin2 = Chance.of(0.5);

    Chance chanceOfGettingAtLeastOneTail = Chance.of(0.75);

    assertEquals(chanceOfGettingTailInCoin1.or(chanceOfGettingTailInCoin2), chanceOfGettingAtLeastOneTail);
  }
}

