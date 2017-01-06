package io.github.rockerhieu.x1f638;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import com.crashlytics.android.Crashlytics;
import io.fabric.sdk.android.Fabric;
import io.github.rockerhieu.x1f638.mvc.MvcActivity;
import io.github.rockerhieu.x1f638.mvp.MvpActivity;
import io.github.rockerhieu.x1f638.mvvm.MvvmActivity;
import io.github.rockerhieu.x1f638.mvvm.rx.MvvmRxActivity;

public class MainActivity extends AppCompatActivity {

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    Fabric.with(this, new Crashlytics());
    setContentView(R.layout.activity_main);
  }

  public void onMvcClicked(View view) {
    startActivity(new Intent(this, MvcActivity.class));
  }

  public void onMvpClicked(View view) {
    startActivity(new Intent(this, MvpActivity.class));
  }

  public void onMvvmClicked(View view) {
    startActivity(new Intent(this, MvvmActivity.class));
  }

  public void onMvvmRxClicked(View view) {
    startActivity(new Intent(this, MvvmRxActivity.class));
  }
}
