package ru.iteco.fmhandroid.ui;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import ru.iteco.fmhandroid.R;

@RunWith(AndroidJUnit4.class)
public class NewsPageTest {

    AuthUtils authUtils = new AuthUtils();

    @Rule
    public ActivityScenarioRule<AppActivity> activityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);

    @Before
    public void init() {
        authUtils.login("login2", "password2");

        ViewInteraction mainMenuImageButton = onView(withId(R.id.main_menu_image_button));
        mainMenuImageButton.check(matches(isDisplayed()));
        mainMenuImageButton.perform(click());

        ViewInteraction aboutButton = onView(withText("News"));
        aboutButton.check(matches(isDisplayed()));
        aboutButton.perform(click());

        ViewInteraction pageOfNews = onView(withId(R.id.all_news_cards_block_constraint_layout));
        pageOfNews.check(matches(isDisplayed()));
    }

    @After
    public void reset() {
        authUtils.logout();
    }

    @Test
    public void testToAboutPage() {
        ViewInteraction mainMenuImageButton = onView(withId(R.id.main_menu_image_button));
        mainMenuImageButton.check(matches(isDisplayed()));
        mainMenuImageButton.perform(click());

        ViewInteraction aboutButton = onView(withText("About"));
        aboutButton.check(matches(isDisplayed()));
        aboutButton.perform(click());
    }
}
