package io.github.rockerhieu.x1f638.mvvm;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import io.github.rockerhieu.x1f638.R;
import io.github.rockerhieu.x1f638.databinding.ActivityCounterMvvmBinding;

public class MvvmActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityCounterMvvmBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_counter_mvvm);
        binding.setData(new CounterViewModel(0));
    }
}
