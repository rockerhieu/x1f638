package io.github.rockerhieu.x1f638.mvvm;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.view.View;
import io.github.rockerhieu.x1f638.BR;

/**
 * Created by rockerhieu on 11/2/15.
 */
public class CounterViewModel extends BaseObservable {
    private int value;

    public CounterViewModel(int initialValue) {
        this.value = initialValue;
    }

    public void setValue(int value) {
        this.value = value;
        notifyPropertyChanged(BR.value);
    }

    @Bindable
    public int getValue() {
        return value;
    }

    public int increase() {
        setValue(value + 1);
        return value;
    }

    public void onIncreaseClicked(View v) {
        increase();
    }
}
