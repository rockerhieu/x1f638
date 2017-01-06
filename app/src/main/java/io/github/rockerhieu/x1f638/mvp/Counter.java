package io.github.rockerhieu.x1f638.mvp;

/**
 * Created by rockerhieu on 11/2/15.
 */
public class Counter {
  private int value;

  public Counter(int initialValue) {
    this.value = initialValue;
  }

  public int getValue() {
    return value;
  }

  public int increase() {
    return ++value;
  }
}
