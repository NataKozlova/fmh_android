package ru.iteco.fmhandroid.ui.steps;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.RootMatchers.withDecorView;
import static androidx.test.espresso.matcher.ViewMatchers.hasDescendant;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import android.view.View;

import androidx.test.espresso.contrib.RecyclerViewActions;

import org.hamcrest.Matchers;

import io.qameta.allure.kotlin.Step;
import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.elements.ControlPanelPage;

public class ControlPanelSteps {

    ControlPanelPage controlPanelPage = new ControlPanelPage();
    WaitingUtils waitingUtils = new WaitingUtils();

    @Step("Нажать на кнопку создать новость")
    public void clickCreateNewsButton() {
        controlPanelPage.ButtonCreateNews.check(matches(isDisplayed()));
        controlPanelPage.ButtonCreateNews.perform(click());
    }

    @Step("Удалить новость")
    public void clickDeleteNewsButton(String title) {
        controlPanelPage.newsRecyclerList
                .perform(RecyclerViewActions.actionOnItem(
                        hasDescendant(withText(title)),
                        waitingUtils.clickChildViewWithId(R.id.delete_news_item_image_view)));
        onView(controlPanelPage.ButtonAgreement()).perform(click());
    }

    @Step("Нажать на кнопку редактировать новость")
    public void clickEditButton(String title) {
        controlPanelPage.newsRecyclerList
                .perform(RecyclerViewActions.actionOnItem(
                        hasDescendant(withText(title)),
                        waitingUtils.clickChildViewWithId(R.id.edit_news_item_image_view)));
    }

    @Step("Переключить свитч кнопку активности у новости и сохранить изменения")
    public void clickSwitcherActive() {
        controlPanelPage.switchAction.check(matches(isDisplayed()));
        controlPanelPage.switchAction.perform(click());
        onView(controlPanelPage.ButtonSave()).check(matches(isDisplayed()));
        onView(controlPanelPage.ButtonSave()).perform(click());
        controlPanelPage.pageControlPanel.check(matches(isDisplayed()));
    }

    @Step("Заполнить поля новости")
    public void fillFieldsNews(String description, String titleName) {
        onView(controlPanelPage.ButtonChoseCategory()).check(matches(isDisplayed()));
        onView(controlPanelPage.ButtonChoseCategory()).perform(click());
        onView(controlPanelPage.categoryAnnouncement()).check(matches(isDisplayed()));
        onView(controlPanelPage.categoryAnnouncement()).perform(click(), replaceText("Объявление"), closeSoftKeyboard());
        onView(controlPanelPage.titleCreate()).check(matches(isDisplayed()));
        onView(controlPanelPage.titleCreate()).perform(click(), replaceText(titleName), closeSoftKeyboard());
        onView(controlPanelPage.ButtonPublishDate()).check(matches(isDisplayed()));
        onView(controlPanelPage.ButtonPublishDate()).perform(click());
        onView(controlPanelPage.ButtonAgreement()).check(matches(isDisplayed()));
        onView(controlPanelPage.ButtonAgreement()).perform(click());
        onView(controlPanelPage.ButtonChooseTime()).check(matches(isDisplayed()));
        onView(controlPanelPage.ButtonChooseTime()).perform(click());
        onView(controlPanelPage.ButtonAgreement()).perform(click());
        onView(controlPanelPage.ButtonDescription()).check(matches(isDisplayed()));
        onView(controlPanelPage.ButtonDescription()).perform(replaceText(description), closeSoftKeyboard());
        onView(controlPanelPage.ButtonSave()).check(matches(isDisplayed()));
        onView(controlPanelPage.ButtonSave()).perform(click());
    }

    @Step("Заполнить поля новости, поле 'Категория' пустое")
    public void fillFieldsNewsCategoryEmpty(String description, String titleName) {
        onView(controlPanelPage.titleCreate()).check(matches(isDisplayed()));
        onView(controlPanelPage.titleCreate()).perform(click(), replaceText(titleName), closeSoftKeyboard());
        onView(controlPanelPage.ButtonPublishDate()).check(matches(isDisplayed()));
        onView(controlPanelPage.ButtonPublishDate()).perform(click());
        onView(controlPanelPage.ButtonAgreement()).check(matches(isDisplayed()));
        onView(controlPanelPage.ButtonAgreement()).perform(click());
        onView(controlPanelPage.ButtonChooseTime()).check(matches(isDisplayed()));
        onView(controlPanelPage.ButtonChooseTime()).perform(click());
        onView(controlPanelPage.ButtonAgreement()).perform(click());
        onView(controlPanelPage.ButtonDescription()).check(matches(isDisplayed()));
        onView(controlPanelPage.ButtonDescription()).perform(replaceText(description), closeSoftKeyboard());
        onView(controlPanelPage.ButtonSave()).check(matches(isDisplayed()));
        onView(controlPanelPage.ButtonSave()).perform(click());
    }

    @Step("Поле 'Категория' пустое")
    public void checkMessageEmptyCategoryField(String text, View decorView) {
        onView(withText(text))
                .inRoot(withDecorView(Matchers.not(decorView)))
                .check(matches(isDisplayed()));
    }

    @Step("Редактировать существующую новость")
    public void editCreatedNews(String description) {
        onView(controlPanelPage.ButtonDescription()).check(matches(isDisplayed()));
        onView(controlPanelPage.ButtonDescription()).perform(replaceText(description), closeSoftKeyboard());
        onView(controlPanelPage.ButtonSave()).check(matches(isDisplayed()));
        onView(controlPanelPage.ButtonSave()).perform(click());
        controlPanelPage.pageControlPanel.check(matches(isDisplayed()));
    }
}
