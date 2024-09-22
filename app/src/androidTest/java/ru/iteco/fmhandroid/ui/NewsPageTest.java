package ru.iteco.fmhandroid.ui;


import androidx.test.ext.junit.rules.ActivityScenarioRule;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;

@RunWith(AllureAndroidJUnit4.class)
public class NewsPageTest {

    AuthUtils authUtils = new AuthUtils();
    StepUtils stepUtils = new StepUtils();

    @Rule
    public ActivityScenarioRule<AppActivity> activityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);

    @Before
    public void init() {
        authUtils.login();

        stepUtils.clickMenu();
        stepUtils.clickNews();

        stepUtils.checkNewsCardsBlock();
    }

    @After
    public void reset() {
        authUtils.logout();
    }

    @Test
    public void testToAboutPage() {
        stepUtils.clickMenu();
        stepUtils.checkAboutTerms();
    }
}
