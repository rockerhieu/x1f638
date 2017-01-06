package io.github.rockerhieu.x1f638.mvp;

import android.support.annotation.NonNull;
import android.support.annotation.VisibleForTesting;

/**
 * Created by rockerhieu on 11/2/15.
 */
public class CounterPresenterImp implements CounterPresenter {
  private CounterView view;
  private Counter counter;

  public CounterPresenterImp() {
    this(new Counter(0));
  }

  @VisibleForTesting public CounterPresenterImp(@NonNull Counter counter) {
    this.counter = counter;
  }

  public void setView(CounterView view) {
    this.view = view;
  }

  @Override public void onIncreaseClicked() {
    view.setCounterText(String.valueOf(counter.increase()));
    if (counter.getValue() % 3 == 0) {
      view.openCounterDetailsScreen(counter.getValue());
    }
  }
}
