package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;

import io.qameta.allure.kotlin.Step;
import ru.iteco.fmhandroid.ui.elements.AboutPage;
import ru.iteco.fmhandroid.ui.elements.MainPaige;
import ru.iteco.fmhandroid.ui.elements.NewsPage;
import ru.iteco.fmhandroid.ui.elements.OurMissionPage;

public class MainSteps {

    MainPaige mainPaige = new MainPaige();
    NewsPage newsPage = new NewsPage();
    AboutPage aboutPage = new AboutPage();
    OurMissionPage ourMissionPage = new OurMissionPage();

    @Step("Переход в блок 'News'")
    public void goToTheNews() {
        mainPaige.iconMenuButton.check(matches(isDisplayed()));
        mainPaige.iconMenuButton.perform(click());
        mainPaige.newsMenuButton.check(matches(isDisplayed()));
        mainPaige.newsMenuButton.perform(click());
        newsPage.pageOfNews.check(matches(isDisplayed()));
    }

    @Step("Переход в блок 'About'")
    public void goToTheAbout() {
        mainPaige.iconMenuButton.check(matches(isDisplayed()));
        mainPaige.iconMenuButton.perform(click());
        mainPaige.newsMenuButton.check(matches(isDisplayed()));
        mainPaige.aboutMenuButton.perform(click());
        aboutPage.versionAboutPage.check(matches(isDisplayed()));
    }

    @Step("Переход в блок 'Наши цели'")
    public void goToTheOurMission() {
        mainPaige.iconOurMissionButton.check(matches(isDisplayed()));
        mainPaige.iconOurMissionButton.perform(click());
        ourMissionPage.pageOfOurMission.check(matches(isDisplayed()));
    }
}
