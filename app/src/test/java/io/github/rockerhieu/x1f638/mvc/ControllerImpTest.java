package io.github.rockerhieu.x1f638.mvc;

import io.github.rockerhieu.x1f638.ApplicationTestCase;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ControllerImpTest extends ApplicationTestCase {

  @Mock protected Counter mockCounter;

  @Mock protected OnCounterIncreasedListener mockOnCounterIncreasedListener;

  protected CounterController controller;

  @Override public void setUp() throws Exception {
    super.setUp();
    MockitoAnnotations.initMocks(this);

    controller = spy(new CounterControllerImp(mockCounter));
  }

  @Test public void testDefaultConstructor() throws Exception {
    controller = spy(new CounterControllerImp());
    controller.setOnCounterIncreasedListener(mockOnCounterIncreasedListener);
    controller.increase();
    verify(mockOnCounterIncreasedListener).onCounterIncreased(eq(1));
  }

  @Test public void testIncrease() throws Exception {
    controller.increase();
    verify(mockCounter).increase();

    when(mockCounter.increase()).thenReturn(5);
    controller.increase();
    verify(mockCounter, times(2)).increase();
  }
}
