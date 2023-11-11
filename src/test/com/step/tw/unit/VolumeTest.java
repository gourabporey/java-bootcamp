package com.step.tw.unit;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class VolumeTest {
  @Test
  void shouldCheckTheEqualityOfVolumeUnits() {
    Volume oneGallon = Volume.of(1, VolumeUnit.GALLON);
    Volume three_SevenEightLitres = Volume.of(3.78, VolumeUnit.LITER);

    assertEquals(oneGallon, three_SevenEightLitres);
  }
}
