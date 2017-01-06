package io.github.rockerhieu.x1f638.mvp;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import butterknife.Bind;
import butterknife.ButterKnife;
import io.github.rockerhieu.x1f638.R;

public class MvpActivity extends AppCompatActivity implements CounterView {
    @Bind(R.id.increase)
    protected Button vIncrease;
    protected CounterPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_counter);
        ButterKnife.bind(this);
        presenter = new CounterPresenterImp();
        presenter.setView(this);
    }

    public void onIncreaseClicked(View view) {
        presenter.onIncreaseClicked();
    }

    @Override
    public void setCounterText(String text) {
        vIncrease.setText(text);
    }

    @Override
    public void openCounterDetailsScreen(int counter) {
        ProgressDialog dialog = new ProgressDialog(this);
        dialog.setMessage("Opening the details screen...");
        dialog.show();
        vIncrease.postDelayed(() -> {
            dialog.dismiss();
            startActivity(CounterDetailsActivity.getCallingIntent(this, counter));
        }, 3000);
    }
}
