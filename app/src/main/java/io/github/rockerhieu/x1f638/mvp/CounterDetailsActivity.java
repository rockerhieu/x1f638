package io.github.rockerhieu.x1f638.mvp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.test.espresso.IdlingResource;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.widget.TextView;

import com.f2prateek.dart.Dart;
import com.f2prateek.dart.InjectExtra;

import butterknife.Bind;
import butterknife.ButterKnife;
import io.github.rockerhieu.x1f638.R;

import static io.github.rockerhieu.x1f638.Constants.Extras;

public class CounterDetailsActivity extends AppCompatActivity implements CounterDetailsView, IdlingResource {

    public static Intent getCallingIntent(Context context, int counter) {
        Intent intent = new Intent(context, CounterDetailsActivity.class);
        intent.putExtra(Extras.COUNTER, counter);
        return intent;
    }

    @Bind(R.id.counter)
    TextView vCounter;

    @InjectExtra(Extras.COUNTER)
    int xCounter;
    CounterDetailsPresenter presenter;
    ResourceCallback callback;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_counter_details);
        ButterKnife.bind(this);
        Dart.inject(this);
        presenter = new CounterDetailsPresenterImp();
        presenter.setView(this);
        presenter.onCreate();
    }

    @Override
    public void waitAndSetCounterText(long waitTimeInMillis) {
        vCounter.postDelayed(() -> {
            vCounter.setText(String.format("You found %s!", xCounter));
            if (callback != null) {
                callback.onTransitionToIdle();
            }
        }, waitTimeInMillis);
    }

    @Override
    public String getName() {
        return "CounterDetailsActivity";
    }

    @Override
    public boolean isIdleNow() {
        return !TextUtils.isEmpty(vCounter.getText());
    }

    @Override
    public void registerIdleTransitionCallback(ResourceCallback callback) {
        this.callback = callback;
    }
}
