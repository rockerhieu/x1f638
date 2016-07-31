package io.github.rockerhieu.x1f638.mvp;

/**
 * Created by rockerhieu on 7/31/16.
 */
public class CounterDetailsPresenterImp implements CounterDetailsPresenter {
    private CounterDetailsView view;

    @Override
    public void setView(CounterDetailsView view) {
        this.view = view;
    }

    @Override
    public void onCreate() {
        view.waitAndSetCounterText(1000);
    }
}
