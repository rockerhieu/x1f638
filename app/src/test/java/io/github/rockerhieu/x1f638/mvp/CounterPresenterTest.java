package io.github.rockerhieu.x1f638.mvp;

import io.github.rockerhieu.x1f638.ApplicationTestCase;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class CounterPresenterTest extends ApplicationTestCase {

    @Mock
    protected Counter mockCounter;

    @Mock
    protected CounterView mockCounterView;

    protected CounterPresenter counterPresenter;

    @Override
    public void setUp() throws Exception {
        super.setUp();
        MockitoAnnotations.initMocks(this);

        counterPresenter = spy(new CounterPresenterImp(mockCounter));
        counterPresenter.setView(mockCounterView);
    }

    @Test
    public void testDefaultConstructor() throws Exception {
        counterPresenter = spy(new CounterPresenterImp());
        counterPresenter.setView(mockCounterView);
        counterPresenter.onIncreaseClicked();
        verify(mockCounterView).setCounterText(eq("1"));
    }

    @Test
    public void testOnIncreaseClicked() throws Exception {
        when(mockCounter.increase()).thenReturn(5);
        counterPresenter.onIncreaseClicked();
        verify(mockCounterView).setCounterText(eq("5"));
    }
}
