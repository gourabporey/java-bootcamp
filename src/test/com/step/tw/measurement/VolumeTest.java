package com.step.tw.measurement;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VolumeTest {
  @Test
  void shouldCheckTheEqualityOfVolumeUnits() {
    Volume oneGallon = Volume.of(1, VolumeUnit.GALLON);
    Volume three_SevenEightLitres = Volume.of(3.78, VolumeUnit.LITER);

    assertEquals(oneGallon, three_SevenEightLitres);
  }

  @Test
  void shouldAddTwoVolumeOfAnyUnitResultingInLiters() {
    Volume oneGallon = Volume.of(1, VolumeUnit.GALLON);
    Volume oneLiter = Volume.of(1, VolumeUnit.LITER);

    Volume expectedSumOfVolume = Volume.of(4.78, VolumeUnit.LITER);

    assertEquals(oneGallon.add(oneLiter), expectedSumOfVolume);
  }
}
