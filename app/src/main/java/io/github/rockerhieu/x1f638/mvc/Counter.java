package io.github.rockerhieu.x1f638.mvc;

/**
 * Created by rockerhieu on 11/2/15.
 */
public class Counter {
    private int value;

    private OnCounterIncreasedListener onCounterIncreasedListener;

    public Counter(int initialValue) {
        this.value = initialValue;
    }

    public int getValue() {
        return value;
    }

    public int increase() {
        ++value;
        if (onCounterIncreasedListener != null) {
            onCounterIncreasedListener.onCounterIncreased(value);
        }
        return value;
    }

    public void setOnCounterIncreasedListener(OnCounterIncreasedListener listener) {
        this.onCounterIncreasedListener = listener;
    }
}
