package ru.iteco.fmhandroid.ui.tests;


import static ru.iteco.fmhandroid.ui.data.Data.registeredLogin;
import static ru.iteco.fmhandroid.ui.data.Data.validPassword;

import androidx.test.ext.junit.rules.ActivityScenarioRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import io.qameta.allure.android.runners.AllureAndroidJUnit4;
import io.qameta.allure.kotlin.Feature;
import io.qameta.allure.kotlin.Story;
import ru.iteco.fmhandroid.ui.AppActivity;
import ru.iteco.fmhandroid.ui.steps.AuthSteps;
import ru.iteco.fmhandroid.ui.steps.MainSteps;

@RunWith(AllureAndroidJUnit4.class)
@Feature(value = "Тест-кейсы для вкладки Main мобильного приложения Мобильный хоспис.")
public class MainPageTests {

    AuthSteps authStep = new AuthSteps();
    MainSteps mainSteps = new MainSteps();

    @Rule
    public ActivityScenarioRule<AppActivity> mActivityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);

    @Before
    public void setUp() {
        authStep.appDownload();
        try {
            authStep.loadAuthPage();
        } catch (Exception e) {
            authStep.logout();
            authStep.loadAuthPage();
        }
        authStep.login(registeredLogin, validPassword);
        authStep.checkLogoMainPage();
    }

    @Story("Переход во вкладку 'News' через главное меню мобильного приложения")
    @Test
    public void goToTheNewsPage() {
        mainSteps.goToTheNews();
    }

    @Story("Переход во вкладку 'About' через главное меню мобильного приложения")
    @Test
    public void goToTheAboutPage() {
        mainSteps.goToTheAbout();
    }

    @Story("Переход во вкладку 'Наши цели' через главное меню мобильного приложения")
    @Test
    public void goToTheOurMission() {
        mainSteps.goToTheOurMission();
    }
}