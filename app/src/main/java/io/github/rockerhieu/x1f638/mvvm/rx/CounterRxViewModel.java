package io.github.rockerhieu.x1f638.mvvm.rx;

import android.view.View;

import butterknife.OnClick;
import io.github.rockerhieu.x1f638.R;
import rx.subjects.BehaviorSubject;

/**
 * Created by rockerhieu on 11/2/15.
 */
public class CounterRxViewModel {
    private BehaviorSubject<Integer> observableValue;

    public CounterRxViewModel(int initialValue) {
        observableValue = BehaviorSubject.create();
        observableValue.onNext(initialValue);
    }

    public void setValue(int value) {
        observableValue.onNext(value);
    }

    public int getValue() {
        return observableValue.getValue();
    }

    public BehaviorSubject<Integer> observeValue() {
        return observableValue;
    }

    public int increase() {
        setValue(getValue() + 1);
        return getValue();
    }

    @OnClick(R.id.increase)
    public void onIncreaseClicked(View v) {
        increase();
    }
}
