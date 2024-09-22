package ru.iteco.fmhandroid.ui;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.RootMatchers.withDecorView;
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

import org.hamcrest.Matchers;
import org.hamcrest.core.IsInstanceOf;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.Story;
import ru.iteco.fmhandroid.R;

@RunWith(AllureAndroidJUnit4.class)
public class AuthPageTest {

    WaitingUtils waitingUtils = new WaitingUtils();
    AuthUtils authUtils = new AuthUtils();

    @Rule
    public ActivityScenarioRule<AppActivity> activityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);

    private View decorView;

    @Before
    public void setUp() {
        activityScenarioRule.getScenario()
                .onActivity(activity -> decorView = activity.getWindow().getDecorView());
    }

    @After
    public void reset() {
        authUtils.logout();
    }

    @Test
    @Story("Отображение экрана авторизации")
    public void testMoveToAuthPage() throws Exception {
        waitingUtils.waitForView(withId(R.id.login_text_input_layout), 5000);

        onView(withId(R.id.login_text_input_layout))
                .check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)));
    }

    @Test
    @Story("Авторизация с валидными значениями")
    public void testLoginWithValidCredentials() throws Exception {
        authUtils.login();

        waitingUtils.waiting(5000);

        onView(withId(R.id.trademark_image_view)).check(matches(isDisplayed()));
    }

    @Test
    @Story("Авторизация с невалидными значениями")
    public void testLoginWithInvalidCredentials() throws Exception {
        authUtils.login("invalid_username", "invalid_password");

        onView(withText("Something went wrong. Try again later."))
                .inRoot(withDecorView(Matchers.not(decorView)))
                .check(matches(isDisplayed()));
    }


}
