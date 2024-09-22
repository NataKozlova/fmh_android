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

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.Feature;
import io.qameta.allure.kotlin.Story;
import ru.iteco.fmhandroid.R;

@RunWith(AllureAndroidJUnit4.class)
@Feature("Тест-кейсы для загрузочного экрана")
public class SplashScreenPageTest {

    WaitingUtils waitingUtils = new WaitingUtils();
    AuthUtils authUtils = new AuthUtils();

    @Rule
    public ActivityScenarioRule<AppActivity> activityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);

    @Test
    @Story("Отображение экрана загрузки")
    public void testSplashScreenDisplayed() {
        onView(withId(R.id.splashscreen_image_view)).check(matches(ViewMatchers.isDisplayed()));
    }

    @Test
    @Story("Отображение экрана авторизации")
    public void testSplashScreenNavigatesToMain() throws Exception {
        onView(withId(R.id.splashscreen_image_view))
                .check(matches(ViewMatchers.isDisplayed()));

        authUtils.logout();
        waitingUtils.waitForView(withId(R.id.login_text_input_layout), 5000);

        onView(withId(R.id.login_text_input_layout))
                .check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)));
    }
}
