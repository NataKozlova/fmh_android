package ru.iteco.fmhandroid.ui;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withEffectiveVisibility;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import ru.iteco.fmhandroid.R;

@RunWith(AndroidJUnit4.class)
public class SplashScreenPageTest {

    @Rule
    public ActivityScenarioRule<AppActivity> activityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);

    @Test
    public void testSplashScreenDisplayed() {
        onView(withId(R.id.splashscreen_image_view)).check(matches(ViewMatchers.isDisplayed()));
    }

    @Test
    public void testSplashScreenNavigatesToMain() {
        onView(withId(R.id.splashscreen_image_view))
                .check(matches(ViewMatchers.isDisplayed()));

        onView(withId(R.id.login_text_input_layout))
                .check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)));
    }
}
