package ru.iteco.fmhandroid.ui;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.espresso.ViewInteraction;

import io.qameta.allure.kotlin.Step;
import ru.iteco.fmhandroid.R;

public class StepUtils {

    @Step("Нажать на кнопку меню")
    public void clickMenu() {
        ViewInteraction mainMenuImageButton = onView(withId(R.id.main_menu_image_button));
        mainMenuImageButton.check(matches(isDisplayed()));
        mainMenuImageButton.perform(click());
    }

    @Step("Нажать на кнопку 'About'")
    public void clickAbout() {
        ViewInteraction aboutButton = onView(withText("About"));
        aboutButton.check(matches(isDisplayed()));
        aboutButton.perform(click());
    }

    @Step("Нажать на кнопку 'News'")
    public void clickNews() {
        ViewInteraction aboutButton = onView(withText("News"));
        aboutButton.check(matches(isDisplayed()));
        aboutButton.perform(click());
    }

    @Step("Нажать на кнопку 'Our mission'")
    public void clickOurMission() {
        ViewInteraction ourMission = onView(withId(R.id.our_mission_image_button));
        ourMission.check(matches(isDisplayed()));
        ourMission.perform(click());
    }

    @Step("Проверить, что раздел 'Version' отображается")
    public void checkAboutVersion() {
        ViewInteraction aboutVersionTitleTextView = onView(withId(R.id.about_version_title_text_view));
        aboutVersionTitleTextView.check(matches(isDisplayed()));
    }

    @Step("Проверить, что раздел 'Политика конфиденциальности' отображается")
    public void checkAboutPrivacy() {
        ViewInteraction aboutPrivacyPolicy = onView(withId(R.id.about_privacy_policy_value_text_view));
        aboutPrivacyPolicy.check(matches(isDisplayed()));
    }

    @Step("Проверить, что раздел 'Пользовательское соглашение' отображается")
    public void checkAboutTerms() {
        ViewInteraction aboutTerms = onView(withId(R.id.about_terms_of_use_value_text_view));
        aboutTerms.check(matches(isDisplayed()));
    }

    @Step("Проверить, что страница новостей отображается")
    public void checkNewsCardsBlock() {
        ViewInteraction pageOfNews = onView(withId(R.id.all_news_cards_block_constraint_layout));
        pageOfNews.check(matches(isDisplayed()));
    }

    @Step("Проверить, что страница миссии отображается")
    public void checkOurMission() {
        ViewInteraction ourMissionTitle = onView(withId(R.id.our_mission_title_text_view));
        ourMissionTitle.check(matches(isDisplayed()));
    }
}
