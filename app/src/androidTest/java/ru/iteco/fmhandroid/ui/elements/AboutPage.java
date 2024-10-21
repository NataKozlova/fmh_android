package ru.iteco.fmhandroid.ui.elements;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;

public class AboutPage {

    public ViewInteraction versionAboutPage = onView(withId(R.id.about_version_title_text_view));
    public ViewInteraction linkPrivacyPolicyLink = onView(withId(R.id.about_privacy_policy_value_text_view));
    public ViewInteraction linkTermsOfUseLink = onView(withId(R.id.about_terms_of_use_value_text_view));
    public ViewInteraction policyInformation = onView(withText("Политика конфидециальности"));
    public ViewInteraction termsInformation = onView(withText("Пользовательское соглашение"));
}
