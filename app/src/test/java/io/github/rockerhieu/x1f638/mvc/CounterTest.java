package io.github.rockerhieu.x1f638.mvc;

import org.junit.Test;

import io.github.rockerhieu.x1f638.ApplicationTestCase;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class CounterTest extends ApplicationTestCase {

    Counter counter;

    @Override
    public void setUp() throws Exception {
        super.setUp();
        counter = new Counter(0);
    }

    @Test
    public void testIncrease() throws Exception {
        OnCounterIncreasedListener listener = mock(OnCounterIncreasedListener.class);
        assertThat(counter.increase(), is(1));
        assertThat(counter.increase(), is(2));
        counter.setOnCounterIncreasedListener(listener);
        assertThat(counter.increase(), is(3));
        verify(listener).onCounterIncreased(eq(3));
    }

    @Test
    public void testConstructor() throws Exception {
        counter = new Counter(5);
        assertThat(counter.getValue(), is(5));
    }
}
