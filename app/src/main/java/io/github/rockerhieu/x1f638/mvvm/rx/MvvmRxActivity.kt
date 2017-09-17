package io.github.rockerhieu.x1f638.mvvm.rx

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import butterknife.BindView
import butterknife.ButterKnife
import com.trello.rxlifecycle.ActivityEvent.DESTROY
import com.trello.rxlifecycle.components.support.RxAppCompatActivity
import io.github.rockerhieu.x1f638.R
import rx.Observable
import rx.functions.Func1

class MvvmRxActivity : RxAppCompatActivity() {
    @BindView(R.id.increase)
    lateinit var vIncrease: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_counter)
        bindViewModel()
    }

    private fun bindViewModel() {
        ButterKnife.bind(this)
        val viewModel = CounterRxViewModel(0)
        ButterKnife.bind(viewModel, this) // for binding click handler
        bind(viewModel.observeValue(), Func1 { value -> value.toString() }, vIncrease)
    }

    private fun bind(observable: Observable<*>, toString: Func1<Any, String>, txt: TextView) {
        observable.compose(bindUntilEvent(DESTROY)).map(toString).subscribe({ text -> txt.text = text })
    }
}
