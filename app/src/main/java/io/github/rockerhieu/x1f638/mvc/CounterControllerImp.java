package io.github.rockerhieu.x1f638.mvc;

import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;

/**
 * Created by rockerhieu on 11/2/15.
 */
public class CounterControllerImp implements CounterController {
  private Counter counter;

  public CounterControllerImp() {
    this(new Counter(0));
  }

  @VisibleForTesting public CounterControllerImp(@NonNull Counter counter) {
    this.counter = counter;
  }

  @Override public void increase() {
    counter.increase();
  }

  @Override public void setOnCounterIncreasedListener(OnCounterIncreasedListener listener) {
    counter.setOnCounterIncreasedListener(listener);
  }
}
