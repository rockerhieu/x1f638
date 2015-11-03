package io.github.rockerhieu.x1f638.mvc;

/**
 * Created by rockerhieu on 11/2/15.
 */
public interface CounterController {
    void increase();

    void setOnCounterIncreasedListener(OnCounterIncreasedListener listener);
}
