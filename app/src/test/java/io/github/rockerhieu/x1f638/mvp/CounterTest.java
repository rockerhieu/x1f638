package io.github.rockerhieu.x1f638.mvp;

import org.junit.Test;

import io.github.rockerhieu.x1f638.ApplicationTestCase;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class CounterTest extends ApplicationTestCase {

    protected Counter counter;

    @Override
    public void setUp() throws Exception {
        super.setUp();
        counter = new Counter(0);
    }

    @Test
    public void testIncrease() throws Exception {
        assertThat(counter.increase(), is(1));
        assertThat(counter.increase(), is(2));
        assertThat(counter.increase(), is(3));
    }

    @Test
    public void testConstructor() throws Exception {
        counter = new Counter(5);
        assertThat(counter.getValue(), is(5));
    }
}
