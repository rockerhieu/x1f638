package io.github.rockerhieu.x1f638.mvc;

import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import io.github.rockerhieu.x1f638.ApplicationTestCase;
import io.github.rockerhieu.x1f638.Counter;

import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ControllerImpTest extends ApplicationTestCase {

    @Mock
    Counter mockCounter;

    @Mock
    OnCounterIncreasedListener mockOnCounterIncreasedListener;

    CounterController controller;

    @Override
    public void setUp() throws Exception {
        super.setUp();
        MockitoAnnotations.initMocks(this);

        controller = spy(new CounterControllerImp(mockCounter));
    }

    @Test
    public void testIncrease() throws Exception {
        controller.increase();
        verify(mockCounter).increase();

        when(mockCounter.increase()).thenReturn(5);
        controller.setOnCounterIncreasedListener(mockOnCounterIncreasedListener);
        controller.increase();
        verify(mockCounter, times(2)).increase();
        verify(mockOnCounterIncreasedListener).onCounterIncreased(eq(5));
    }
}
