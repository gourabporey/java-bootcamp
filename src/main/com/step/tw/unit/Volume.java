package com.step.tw.unit;

import java.util.Objects;

public class Volume {
  private final double measurement;
  private final VolumeUnit volumeUnit;

  private Volume(double measurement, VolumeUnit volumeUnit) {
    this.measurement = measurement;
    this.volumeUnit = volumeUnit;
  }

  public static Volume of(double measurement, VolumeUnit volumeUnit) {
    return new Volume(measurement, volumeUnit);
  }

  private double convertToStandard() {
    return this.volumeUnit.convertToStandard(this.measurement);
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Volume volume = (Volume) o;
    return Math.abs(this.convertToStandard() - volume.convertToStandard()) < 0.01;
  }

  @Override
  public int hashCode() {
    return Objects.hash(measurement, volumeUnit);
  }

  @Override
  public String toString() {
    return "Volume{" +
        "measurement=" + measurement +
        ", volumeUnit=" + volumeUnit +
        '}';
  }
}