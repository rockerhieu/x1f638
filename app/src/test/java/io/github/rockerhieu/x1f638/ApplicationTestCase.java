package io.github.rockerhieu.x1f638;

import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.robolectric.annotation.Config;

import java.lang.reflect.Field;

/**
 * Base class for Robolectric data layer tests running with a custom Test Runner.
 * Inherit from this class to create a test.
 */
@RunWith(ApplicationTestRunner.class)
@Config(constants = BuildConfig.class, sdk = 23)
public abstract class ApplicationTestCase {

    @Before
    public void setUp() throws Exception {
    }

    @After
    public void tearDown() throws Exception {
    }

    /**
     * Resets a Singleton class.
     * This works using reflection and looking for a private field in the singleton called
     * "INSTANCE".
     * It is actually a workaround (hack?) to avoid global state when testing in isolation.
     *
     * @param clazz The class to reset.
     */
    protected void resetSingleton(Class clazz) {
        Field instance;
        try {
            instance = clazz.getDeclaredField("INSTANCE");
            instance.setAccessible(true);
            instance.set(null, null);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
