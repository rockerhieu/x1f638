package io.github.rockerhieu.x1f638.mvc;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import butterknife.Bind;
import butterknife.ButterKnife;
import io.github.rockerhieu.x1f638.R;

public class MvcActivity extends AppCompatActivity implements OnCounterIncreasedListener {
  @Bind(R.id.increase) protected Button vIncrease;
  protected CounterController controller;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_counter);
    ButterKnife.bind(this);
    controller = new CounterControllerImp();
    controller.setOnCounterIncreasedListener(this);
  }

  @Override protected void onDestroy() {
    super.onDestroy();
    controller.setOnCounterIncreasedListener(null);
  }

  public void onIncreaseClicked(View view) {
    controller.increase();
  }

  @Override public void onCounterIncreased(int value) {
    vIncrease.setText(String.valueOf(value));
  }
}
