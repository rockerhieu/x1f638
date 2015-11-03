package io.github.rockerhieu.x1f638.mvc;

import io.github.rockerhieu.x1f638.Counter;

/**
 * Created by rockerhieu on 11/2/15.
 */
public class CounterControllerImp implements CounterController {
    private Counter counter;
    private OnCounterIncreasedListener onCounterIncreasedListener;

    public CounterControllerImp() {
        this(new Counter());
    }

    public CounterControllerImp(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void increase() {
        int value = counter.increase();
        if (onCounterIncreasedListener != null) {
            onCounterIncreasedListener.onCounterIncreased(value);
        }
    }

    @Override
    public void setOnCounterIncreasedListener(OnCounterIncreasedListener listener) {
        onCounterIncreasedListener = listener;
    }
}
