package io.github.rockerhieu.x1f638.mvvm.rx;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.trello.rxlifecycle.components.support.RxAppCompatActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import io.github.rockerhieu.x1f638.R;
import rx.Observable;
import rx.functions.Func1;

import static com.trello.rxlifecycle.ActivityEvent.DESTROY;

public class MvvmRxActivity extends RxAppCompatActivity {
    @Bind(R.id.increase)
    Button vIncrease;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_counter);
        bindViewModel();
    }

    private void bindViewModel() {
        ButterKnife.bind(this);
        CounterRxViewModel viewModel = new CounterRxViewModel(0);
        ButterKnife.bind(viewModel, this); // for binding click handler
        bind(viewModel.observeValue(), value -> String.valueOf(value), vIncrease);
    }

    private void bind(Observable<?> observable, Func1<Object, String> toString, TextView txt) {
        observable
                .compose(bindUntilEvent(DESTROY))
                .map(toString)
                .subscribe(text -> txt.setText(text));
    }
}
