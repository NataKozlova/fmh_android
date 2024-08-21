package ru.iteco.fmhandroid.ui;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.espresso.ViewInteraction;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import ru.iteco.fmhandroid.R;

@RunWith(AndroidJUnit4.class)
public class MainPageTest {

    AuthUtils authUtils = new AuthUtils();

    @Rule
    public ActivityScenarioRule<AppActivity> activityScenarioRule =
            new ActivityScenarioRule<>(AppActivity.class);

    @Before
    public void init() {
        authUtils.login("login2", "password2");
    }

    @After
    public void reset() {
        authUtils.logout();
    }

    @Test
    public void testNavigateToAboutPage() {
        ViewInteraction mainMenuImageButton = onView(withId(R.id.main_menu_image_button));
        mainMenuImageButton.check(matches(isDisplayed()));
        mainMenuImageButton.perform(click());

        ViewInteraction aboutButton = onView(withText("About"));
        aboutButton.check(matches(isDisplayed()));
        aboutButton.perform(click());

        ViewInteraction aboutVersionTitleTextView = onView(withId(R.id.about_version_title_text_view));
        aboutVersionTitleTextView.check(matches(isDisplayed()));
    }

    @Test
    public void testNavigateToNewsPage() {
        ViewInteraction mainMenuImageButton = onView(withId(R.id.main_menu_image_button));
        mainMenuImageButton.check(matches(isDisplayed()));
        mainMenuImageButton.perform(click());

        ViewInteraction aboutButton = onView(withText("News"));
        aboutButton.check(matches(isDisplayed()));
        aboutButton.perform(click());

        ViewInteraction pageOfNews = onView(withId(R.id.all_news_cards_block_constraint_layout));
        pageOfNews.check(matches(isDisplayed()));
    }

    @Test
    public void testNavigateToMissionScreen() {
        ViewInteraction ourMission = onView(withId(R.id.our_mission_image_button));
        ourMission.check(matches(isDisplayed()));
        ourMission.perform(click());

        ViewInteraction ourMissionTitle = onView(withId(R.id.our_mission_title_text_view));
        ourMissionTitle.check(matches(isDisplayed()));
    }
}
