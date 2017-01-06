package io.github.rockerhieu.x1f638.mvvm;

import io.github.rockerhieu.x1f638.ApplicationTestCase;
import io.github.rockerhieu.x1f638.BR;
import org.junit.Test;
import org.mockito.MockitoAnnotations;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

public class CounterViewModelTest extends ApplicationTestCase {

  protected CounterViewModel model;

  @Override public void setUp() throws Exception {
    super.setUp();
    MockitoAnnotations.initMocks(this);

    model = spy(new CounterViewModel(0));
  }

  @Test public void testSetValue() throws Exception {
    model.setValue(5);
    assertThat(model.getValue(), is(5));
    verify(model).notifyPropertyChanged(BR.value);
  }

  @Test public void testIncrease() throws Exception {
    model.increase();
    assertThat(model.getValue(), is(1));
    model.increase();
    assertThat(model.getValue(), is(2));
  }

  @Test public void testOnIncreaseClicked() throws Exception {
    model.onIncreaseClicked(null);
    verify(model).increase();
  }
}
