package ru.iteco.fmhandroid.ui.tests;


import static ru.iteco.fmhandroid.ui.data.Data.changeDescription;
import static ru.iteco.fmhandroid.ui.data.Data.description;
import static ru.iteco.fmhandroid.ui.data.Data.registeredLogin;
import static ru.iteco.fmhandroid.ui.data.Data.titleNameForChangeActive;
import static ru.iteco.fmhandroid.ui.data.Data.titleNameForCreate;
import static ru.iteco.fmhandroid.ui.data.Data.titleNameForDelete;
import static ru.iteco.fmhandroid.ui.data.Data.titleNameForEdit;
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
import ru.iteco.fmhandroid.ui.steps.ControlPanelSteps;
import ru.iteco.fmhandroid.ui.steps.MainSteps;
import ru.iteco.fmhandroid.ui.steps.NewsSteps;

@RunWith(AllureAndroidJUnit4.class)
@Feature(value = "Тест-кейсы для вкладки 'Control panel'")
public class ControlPanelTests {

    AuthSteps authStep = new AuthSteps();
    MainSteps mainSteps = new MainSteps();
    NewsSteps newsSteps = new NewsSteps();
    ControlPanelSteps controlPanelSteps = new ControlPanelSteps();

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
        mActivityScenarioRule.getScenario()
                .onActivity(activity -> decorView = activity.getWindow().getDecorView());
    }

    private View decorView;

    @Story("Создание новости во вкладке 'Control panel'")
    @Test
    public void createNews() {
        mainSteps.goToTheNews();
        newsSteps.clickButtonEditNews();
        controlPanelSteps.clickCreateNewsButton();
        controlPanelSteps.fillFieldsNews(description, titleNameForCreate);
        controlPanelSteps.clickDeleteNewsButton(titleNameForCreate);
    }

    @Story("Удаление новости во вкладке 'Control panel'")
    @Test
    public void deleteNews() {
        mainSteps.goToTheNews();
        newsSteps.clickButtonEditNews();
        controlPanelSteps.clickCreateNewsButton();
        controlPanelSteps.fillFieldsNews(description, titleNameForDelete);
        controlPanelSteps.clickDeleteNewsButton(titleNameForDelete);
    }

    @Story("Редактирование новости во вкладке 'Control panel'")
    @Test
    public void editNews() {
        mainSteps.goToTheNews();
        newsSteps.clickButtonEditNews();
        controlPanelSteps.clickCreateNewsButton();
        controlPanelSteps.fillFieldsNews(description, titleNameForEdit);
        controlPanelSteps.clickEditButton(titleNameForEdit);
        controlPanelSteps.editCreatedNews(changeDescription);
        controlPanelSteps.clickDeleteNewsButton(titleNameForEdit);
    }

    @Story("Смена статуса новости, находящаяся в статусе 'Active' на статус 'Not active', во вкладке 'Control panel'")
    @Test
    public void changeStatusOfNews() {
        mainSteps.goToTheNews();
        newsSteps.clickButtonEditNews();
        controlPanelSteps.clickCreateNewsButton();
        controlPanelSteps.fillFieldsNews(description, titleNameForChangeActive);
        controlPanelSteps.clickEditButton(titleNameForChangeActive);
        controlPanelSteps.clickSwitcherActive();
        controlPanelSteps.clickDeleteNewsButton(titleNameForChangeActive);
    }

    @Story("Поле 'Категория' пустое, при создании новости, во вкладке 'Control panel'")
    @Test
    public void createNewsFieldCategoryEmpty() {
        mainSteps.goToTheNews();
        newsSteps.clickButtonEditNews();
        controlPanelSteps.clickCreateNewsButton();
        controlPanelSteps.fillFieldsNewsCategoryEmpty(description, titleNameForCreate);
        controlPanelSteps.checkMessageEmptyCategoryField("Fill empty fields", decorView);
    }
}