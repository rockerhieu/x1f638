package io.github.rockerhieu.x1f638.mvp;

import io.github.rockerhieu.x1f638.Counter;

/**
 * Created by rockerhieu on 11/2/15.
 */
public class CounterPresenterImp implements CounterPresenter {
    private CounterView view;
    private Counter counter;

    public CounterPresenterImp() {
        this(new Counter());
    }

    public CounterPresenterImp(Counter counter) {
        this.counter = counter;
    }

    public void setView(CounterView view) {
        this.view = view;
    }

    @Override
    public void onIncreaseClicked() {
        view.setCounterText(String.valueOf(counter.increase()));
    }
}
