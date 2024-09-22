package ru.iteco.fmhandroid.ui;


import androidx.test.ext.junit.rules.ActivityScenarioRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.Story;

@RunWith(AllureAndroidJUnit4.class)
public class AboutPageTest {

    AuthUtils authUtils = new AuthUtils();
    StepUtils stepUtils = new StepUtils();

    @Rule
    public ActivityScenarioRule<AppActivity> activityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);

    @Before
    public void init() {
        authUtils.login();

        stepUtils.clickMenu();
        stepUtils.clickAbout();
    }

    @After
    public void reset() {
        authUtils.logout();
    }

    @Test
    @Story("Проверяем наличие отображение 'Политика конфиденциальности'")
    public void testPrivacyPolicy() {
        stepUtils.checkAboutPrivacy();
        /*aboutPrivacyPolicy.perform(click());
        ViewInteraction policyInformation = onView(withText("Политика конфидециальности"));
        policyInformation.check(matches(isDisplayed()));*/
    }

    @Test
    @Story("Проверяем наличие отображение 'Пользовательское соглашение'")
    public void testAboutTerms() {
        stepUtils.checkAboutTerms();
        /*aboutTerms.perform(click());
        ViewInteraction termsInformation = onView(withText("Пользовательское соглашение"));
        termsInformation.check(matches(isDisplayed()));*/
    }
}
