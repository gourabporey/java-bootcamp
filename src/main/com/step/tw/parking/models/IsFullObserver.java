package com.step.tw.parking.models;

public interface IsFullObserver extends Observer {
  void informIsFull(String id);
}
