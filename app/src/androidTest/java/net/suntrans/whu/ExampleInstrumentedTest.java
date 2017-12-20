package net.suntrans.whu;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import net.suntrans.whu.bean.User;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("net.suntrans.whu", appContext.getPackageName());
    }

    @Test
    public static User getATestUser(int id) {
        User user = new User();
        user.username = "username" + id;
        user.password = "password" + id;
        user.id = id;
        return user;
    }

    public void TestDatabase(){

    }
}
