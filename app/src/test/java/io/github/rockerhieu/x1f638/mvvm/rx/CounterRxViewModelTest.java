package io.github.rockerhieu.x1f638.mvvm.rx;

import org.junit.Test;
import org.mockito.MockitoAnnotations;

import io.github.rockerhieu.x1f638.ApplicationTestCase;
import io.github.rockerhieu.x1f638.BR;
import io.github.rockerhieu.x1f638.mvvm.CounterViewModel;
import rx.observers.TestSubscriber;
import rx.schedulers.TestScheduler;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

public class CounterRxViewModelTest extends ApplicationTestCase {

    protected CounterRxViewModel model;

    @Override
    public void setUp() throws Exception {
        super.setUp();
        MockitoAnnotations.initMocks(this);

        model = spy(new CounterRxViewModel(1));
    }

    @Test
    public void testSetValue() throws Exception {
        TestSubscriber<Integer> testSubscriber = new TestSubscriber<>();
        model.observeValue().subscribe(testSubscriber);
        model.setValue(5);
        testSubscriber.assertValues(1, 5);
        assertThat(model.getValue(), is(5));
    }

    @Test
    public void testIncrease() throws Exception {
        model.increase();
        assertThat(model.getValue(), is(2));
        model.increase();
        assertThat(model.getValue(), is(3));
    }

    @Test
    public void testOnIncreaseClicked() throws Exception {
        model.onIncreaseClicked(null);
        verify(model).increase();
    }
}
