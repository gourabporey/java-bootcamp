package com.step.tw.measurement;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MeasureTest {
  @Test
  void shouldBeAbleToCompareFeetToInches() {
    Measure<LengthUnit> oneFeet = new Measure<>(1, LengthUnit.FEET);
    Measure<LengthUnit> twelveInches = new Measure<>(12, LengthUnit.INCH);

    assertEquals(oneFeet, twelveInches);
  }

  @Test
  void shouldBeAbleToCompareFeetToCentimeters() {
    Measure<LengthUnit> twoInches = new Measure<>(2, LengthUnit.INCH);
    Measure<LengthUnit> fiveCms = new Measure<>(5, LengthUnit.CENTIMETER);

    assertEquals(twoInches, fiveCms);
  }

  @Test
  void oneCentimeterShouldBeEqualToTenMillimeter() {
    Measure<LengthUnit> oneCm = new Measure<>(1, LengthUnit.CENTIMETER);
    Measure<LengthUnit> tenMm = new Measure<>(10, LengthUnit.MILLIMETER);

    assertEquals(oneCm, tenMm);
  }

  @Test
  void shouldCheckTheEqualityOfVolumeUnits() {
    Measure<VolumeUnit> oneGallon = new Measure<>(1, VolumeUnit.GALLON);
    Measure<VolumeUnit> three_SevenEightLitres = new Measure<>(3.78, VolumeUnit.LITER);

    assertEquals(oneGallon, three_SevenEightLitres);
  }

  @Test
  void shouldAddTwoVolumeOfAnyUnitResultingInLiters() {
    Measure<VolumeUnit> oneGallon = new Measure<>(1, VolumeUnit.GALLON);
    Measure<VolumeUnit> oneLiter = new Measure<>(1, VolumeUnit.LITER);

    Measure<VolumeUnit> expectedSumOfVolume = new Measure<>(4.78, VolumeUnit.LITER);

    assertEquals(oneGallon.add(oneLiter), expectedSumOfVolume);
  }

  @Test
  void shouldAddTwoLengthOfSameUnits() {
    Measure<LengthUnit> twoInch = new Measure<>(2, LengthUnit.INCH);
    Measure<LengthUnit> fourInch = new Measure<>(4, LengthUnit.INCH);

    assertEquals(twoInch.add(twoInch), fourInch);
  }

  @Test
  void shouldTwoLengthOfAnyUnitResultingInInches() {
    Measure<LengthUnit> twoInches =  new Measure<>(2, LengthUnit.INCH);
    Measure<LengthUnit> two_FiveCM = new Measure<>(2.54, LengthUnit.CENTIMETER);
    Measure<LengthUnit> threeInches = new Measure<>(3, LengthUnit.INCH);

    assertEquals(twoInches.add(two_FiveCM), threeInches);
  }

  @Test
  void hundredCelsiusIsEqualToTwoHundredTwelveFahrenheit() {
    Measure<TemperatureUnit> hundredCelsius = new Measure<>(100, TemperatureUnit.CELSIUS);
    Measure<TemperatureUnit> twoHundredTwelveF = new Measure<>(212, TemperatureUnit.FAHRENHEIT);

    assertEquals(hundredCelsius, twoHundredTwelveF);
  }
}
