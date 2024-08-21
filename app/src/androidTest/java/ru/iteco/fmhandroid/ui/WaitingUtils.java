package ru.iteco.fmhandroid.ui;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;

import android.view.View;

import org.hamcrest.Matcher;

import java.util.concurrent.TimeoutException;

public class WaitingUtils {

    public void waitForView(final Matcher<View> viewMatcher, final int timeout) throws Exception {
        long endTime = System.currentTimeMillis() + timeout;
        while (System.currentTimeMillis() < endTime) {
            try {
                onView(viewMatcher).check(matches(isDisplayed()));
                return;
            } catch (Exception e) {
            }
            Thread.sleep(500);
        }
        throw new TimeoutException("View not found within " + timeout + "ms");
    }
}
