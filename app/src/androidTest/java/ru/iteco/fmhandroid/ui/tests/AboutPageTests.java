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
import ru.iteco.fmhandroid.ui.steps.AboutPageSteps;
import ru.iteco.fmhandroid.ui.steps.AuthSteps;
import ru.iteco.fmhandroid.ui.steps.MainSteps;

@RunWith(AllureAndroidJUnit4.class)
@Feature(value = "Тест-кейсы для вкладки About")
public class AboutPageTests {

    AuthSteps authStep = new AuthSteps();
    MainSteps mainSteps = new MainSteps();
    AboutPageSteps aboutPageSteps = new AboutPageSteps();

    @Rule
    public ActivityScenarioRule<AppActivity> activityScenarioRule =
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

    @Story("Просмотр ссылки 'Политика конфиденциальности' во вкладке 'About'")
    @Test
    public void checkLinkPrivatePolicy() {
        mainSteps.goToTheAbout();
        aboutPageSteps.goToTheLinkPrivacyPolicy();
    }

    @Story("Просмотр ссылки 'Пользовательское соглашение' во вкладке 'About'")
    @Test
    public void checkLinkTermsOfUse() {
        mainSteps.goToTheAbout();
        aboutPageSteps.goToTheLinkTermsOfUse();
    }
}
