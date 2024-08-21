package ru.iteco.fmhandroid.ui;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.espresso.ViewInteraction;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import ru.iteco.fmhandroid.R;

@RunWith(AndroidJUnit4.class)
public class AboutPageTest {

    AuthUtils authUtils = new AuthUtils();

    @Rule
    public ActivityScenarioRule<AppActivity> activityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);

    @Before
    public void init() {
        authUtils.login("login2", "password2");

        ViewInteraction mainMenuImageButton = onView(withId(R.id.main_menu_image_button));
        mainMenuImageButton.check(matches(isDisplayed()));
        mainMenuImageButton.perform(click());

        ViewInteraction aboutButton = onView(withText("About"));
        aboutButton.check(matches(isDisplayed()));
        aboutButton.perform(click());

        ViewInteraction aboutVersionTitleTextView = onView(withId(R.id.about_version_title_text_view));
        aboutVersionTitleTextView.check(matches(isDisplayed()));
    }

    @After
    public void reset() {
        authUtils.logout();
    }

    @Test
    public void testPrivacyPolicy() {
        ViewInteraction aboutPrivacyPolicy = onView(withId(R.id.about_privacy_policy_value_text_view));
        aboutPrivacyPolicy.check(matches(isDisplayed()));
        aboutPrivacyPolicy.perform(click());
        ViewInteraction policyInformation = onView(withText("Политика конфидециальности"));
        policyInformation.check(matches(isDisplayed()));
    }

    @Test
    public void testAboutTerms() {
        ViewInteraction aboutTerms = onView(withId(R.id.about_terms_of_use_value_text_view));
        aboutTerms.check(matches(isDisplayed()));
        aboutTerms.perform(click());
        ViewInteraction termsInformation = onView(withText("Пользовательское соглашение"));
        termsInformation.check(matches(isDisplayed()));
    }
}
