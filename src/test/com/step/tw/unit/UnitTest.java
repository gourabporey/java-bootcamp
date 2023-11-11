package com.step.tw.unit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UnitTest {
  @Test
  void twoInchesShouldBeEqualsToFiveCentimeters() {
    Unit twoInches = Unit.of(2, LengthUnit.INCH);
    Unit fiveCentimeters = Unit.of(5, LengthUnit.CENTIMETER);

    assertEquals(twoInches, fiveCentimeters);
  }

  @Test
  void oneFeetShouldBeEqualToTwelveInches() {
    Unit oneFeet = Unit.of(1.0, LengthUnit.FEET);
    Unit twelveInches = Unit.of(12, LengthUnit.INCH);

    assertEquals(oneFeet, twelveInches);
  }

  @Test
  void oneCentimeterShouldBeEqualToTenMillimeter() {
    Unit oneCm = Unit.of(1, LengthUnit.CENTIMETER);
    Unit tenMm = Unit.of(10, LengthUnit.MILLIMETER);

    assertEquals(oneCm, tenMm);
  }
}
