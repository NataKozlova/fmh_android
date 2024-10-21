package ru.iteco.fmhandroid.ui.tests;

import static ru.iteco.fmhandroid.ui.data.Data.notRegisteredLogin;
import static ru.iteco.fmhandroid.ui.data.Data.registeredLogin;
import static ru.iteco.fmhandroid.ui.data.Data.validPassword;

import android.view.View;

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

@RunWith(AllureAndroidJUnit4.class)
@Feature(value = "Тест-кейсы по процессу Авторизация, аутентификация.")
public class AuthTests {

    AuthSteps authStep = new AuthSteps();

    @Rule
    public ActivityScenarioRule<AppActivity> activityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);

    private View decorView;

    @Before
    public void setUp() {
        authStep.appDownload();
        try {
            authStep.loadAuthPage();
        } catch (Exception e) {
            authStep.logout();
            authStep.loadAuthPage();
        }
        activityScenarioRule.getScenario()
                .onActivity(activity -> decorView = activity.getWindow().getDecorView());
    }

    @Story("Авторизация в мобильном приложении(зарегистрированный пользователь")
    @Test
    public void authRegisteredUser() {
        authStep.login(registeredLogin, validPassword);
        authStep.checkLogoMainPage();
        authStep.logout();
    }

    @Story("Выход из учётной записи")
    @Test
    public void logout() {
        authStep.login(registeredLogin, validPassword);
        authStep.checkLogoMainPage();
        authStep.logout();
    }

    @Story("Авторизация в мобильном приложении незарегистрированного пользователя")
    @Test
    public void authNotRegisteredUser() {
        authStep.login(notRegisteredLogin, validPassword);
        authStep.checkMessageNotRegisteredUser("Something went wrong. Try again later.", decorView);
    }
}
