package com.step.tw.unit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LengthTest {
  @Test
  void twoInchesShouldBeEqualsToFiveCentimeters() {
    Length twoInches = Length.ofInch(2);
    Length fiveCentimeters = Length.ofCentimeter(5);

    assertEquals(twoInches, fiveCentimeters);
  }

  @Test
  void oneFeetShouldBeEqualToTwelveInches() {
    Length oneFeet = Length.ofFeet(1.0);
    Length twelveInches = Length.ofInch(12);

    assertEquals(oneFeet, twelveInches);
  }

  @Test
  void oneCentimeterShouldBeEqualToTenMillimeter() {
    Length oneCm = Length.ofCentimeter(1);
    Length tenMm = Length.ofMillimeter(10);

    assertEquals(oneCm, tenMm);
  }
}
