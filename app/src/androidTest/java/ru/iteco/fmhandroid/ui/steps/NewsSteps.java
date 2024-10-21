package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;

import io.qameta.allure.kotlin.Step;
import ru.iteco.fmhandroid.ui.elements.ControlPanelPage;
import ru.iteco.fmhandroid.ui.elements.NewsPage;

public class NewsSteps {

    ControlPanelPage controlPanelPage = new ControlPanelPage();
    NewsPage newsPage = new NewsPage();

    @Step("Переход на страницу 'Control Panel'")
    public void clickButtonEditNews() {
        onView(newsPage.buttonEditNews()).check(matches(isDisplayed()));
        onView(newsPage.buttonEditNews()).perform(click());
        controlPanelPage.pageControlPanel.check(matches(isDisplayed()));
    }
}