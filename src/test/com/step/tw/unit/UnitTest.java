package com.step.tw.unit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class UnitTest {
  @Test
  void shouldTellIfALengthIsGreaterThanOther() {
    Unit oneFeet = new Unit(12);
    Unit sixInches = new Unit(6);

    assertTrue(oneFeet.isGreater(sixInches));
  }

  @Test
  void oneFeetShouldBeEqualToTwelveInches() {
    Unit oneFeet = new Unit(12);
    Unit twelveInches = new Unit(12);

    assertTrue(oneFeet.equals(twelveInches));
  }
}
