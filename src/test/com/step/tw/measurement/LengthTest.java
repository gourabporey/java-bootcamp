package com.step.tw.measurement;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LengthTest {
  @Test
  void twoInchesShouldBeEqualsToFiveCentimeters() {
    Length twoInches = Length.of(2, LengthUnit.INCH);
    Length fiveCentimeters = Length.of(5, LengthUnit.CENTIMETER);

    assertEquals(twoInches, fiveCentimeters);
  }

  @Test
  void oneFeetShouldBeEqualToTwelveInches() {
    Length oneFeet = Length.of(1.0, LengthUnit.FEET);
    Length twelveInches = Length.of(12, LengthUnit.INCH);

    assertEquals(oneFeet, twelveInches);
  }

  @Test
  void oneCentimeterShouldBeEqualToTenMillimeter() {
    Length oneCm = Length.of(1, LengthUnit.CENTIMETER);
    Length tenMm = Length.of(10, LengthUnit.MILLIMETER);

    assertEquals(oneCm, tenMm);
  }

  @Test
  void shouldAddTwoLengthOfSameUnits() {
    Length twoInch = Length.of(2, LengthUnit.INCH);
    Length fourInch = Length.of(4, LengthUnit.INCH);

    assertEquals(twoInch.add(twoInch), fourInch);
  }

  @Test
  void shouldTwoLengthOfAnyUnitResultingInInches() {
    Length twoInches = Length.of(2, LengthUnit.INCH);
    Length two_FiveCM = Length.of(2.54, LengthUnit.CENTIMETER);
    Length threeInches = Length.of(3, LengthUnit.INCH);

    assertEquals(twoInches.add(two_FiveCM), threeInches);
  }
}
