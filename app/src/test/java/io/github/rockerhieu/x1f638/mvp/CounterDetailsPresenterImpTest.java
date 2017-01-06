package io.github.rockerhieu.x1f638.mvp;

import io.github.rockerhieu.x1f638.ApplicationTestCase;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

public class CounterDetailsPresenterImpTest extends ApplicationTestCase {
  protected @Mock CounterDetailsView mockView;

  protected CounterDetailsPresenterImp presenter;

  @Override public void setUp() throws Exception {
    super.setUp();
    MockitoAnnotations.initMocks(this);

    presenter = spy(new CounterDetailsPresenterImp());
    presenter.setView(mockView);
  }

  @Test public void testSetView() throws Exception {
    assertThat(presenter.view, is(mockView));
  }

  @Test public void testOnCreate() throws Exception {
    presenter.onCreate();
    verify(mockView).waitAndSetCounterText(eq(1000L));
  }
}
