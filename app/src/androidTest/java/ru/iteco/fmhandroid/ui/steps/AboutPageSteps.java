package ru.iteco.fmhandroid.ui.steps;


import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;

import io.qameta.allure.kotlin.Step;
import ru.iteco.fmhandroid.ui.elements.AboutPage;

public class AboutPageSteps {

    AboutPage aboutPage = new AboutPage();

    @Step("Переход по ссылке 'Политика конфиденциальности'")
    public void goToTheLinkPrivacyPolicy() {
        aboutPage.linkPrivacyPolicyLink.check(matches(isDisplayed()));
        aboutPage.linkPrivacyPolicyLink.perform(click());
        aboutPage.policyInformation.check(matches(isDisplayed()));
    }

    @Step("Переход по ссылке 'Пользовательское соглашение'")
    public void goToTheLinkTermsOfUse() {
        aboutPage.linkTermsOfUseLink.check(matches(isDisplayed()));
        aboutPage.linkTermsOfUseLink.perform(click());
        aboutPage.termsInformation.check(matches(isDisplayed()));
    }
}