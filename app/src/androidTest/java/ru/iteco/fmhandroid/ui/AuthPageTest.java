package ru.iteco.fmhandroid.ui;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withEffectiveVisibility;
import static androidx.test.espresso.matcher.ViewMatchers.withHint;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.not;

import android.view.View;

import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.hamcrest.core.IsInstanceOf;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import ru.iteco.fmhandroid.R;

@RunWith(AndroidJUnit4.class)
public class AuthPageTest {

    WaitingUtils waitingUtils = new WaitingUtils();
    AuthUtils authUtils = new AuthUtils();
    @Rule
    public ActivityScenarioRule<AppActivity> activityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);

    @Test
    public void testMoveToAuthPage() throws Exception {
        waitingUtils.waitForView(withId(R.id.login_text_input_layout), 5000);

        onView(withId(R.id.login_text_input_layout))
                .check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)));
    }
    @Test
    public void testLoginWithValidCredentials() throws Exception {
        waitingUtils.waitForView(withId(R.id.login_text_input_layout), 5000);

        authUtils.login("login2", "password2");

        waitingUtils.waitForView(withId(R.id.trademark_image_view), 10000);

        ViewInteraction imageView = onView(
                allOf(withId(R.id.trademark_image_view),
                        withParent(allOf(withId(R.id.container_custom_app_bar_include_on_fragment_main),
                                withParent(IsInstanceOf.<View>instanceOf(android.widget.LinearLayout.class)))),
                        isDisplayed()));
        imageView.check(matches(isDisplayed()));

        authUtils.logout();
    }

    @Test
    public void testLoginWithInvalidCredentials() throws Exception {
        waitingUtils.waitForView(withId(R.id.login_text_input_layout), 5000);

        authUtils.login("invalid_username", "invalid_password");

        waitingUtils.waitForView(withId(R.id.trademark_image_view), 10000);

        ViewInteraction imageView = onView(
                allOf(withId(R.id.trademark_image_view),
                        withParent(allOf(withId(R.id.container_custom_app_bar_include_on_fragment_main),
                                withParent(IsInstanceOf.<View>instanceOf(android.widget.LinearLayout.class)))),
                        isDisplayed()));
        imageView.check(matches(not(isDisplayed())));
    }


}
