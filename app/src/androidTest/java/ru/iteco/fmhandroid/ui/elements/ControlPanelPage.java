package ru.iteco.fmhandroid.ui.elements;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.allOf;

import android.view.View;

import androidx.test.espresso.ViewInteraction;

import org.hamcrest.Matcher;

import ru.iteco.fmhandroid.R;
import ru.iteco.fmhandroid.ui.steps.TimeoutEspresso;

public class ControlPanelPage {

    TimeoutEspresso timeoutEspresso = new TimeoutEspresso();

    public ViewInteraction ButtonCreateNews = onView(withId(R.id.add_news_image_view));

    public ViewInteraction switchAction = onView(withId(R.id.switcher));

    public Matcher<View> ButtonChoseCategory() {
        return allOf(withId(R.id.news_item_category_text_auto_complete_text_view));
    }

    public Matcher<View> categoryAnnouncement() {
        return allOf(withId(R.id.news_item_category_text_auto_complete_text_view));
    }

    public Matcher<View> ButtonPublishDate() {
        return allOf(withId(R.id.news_item_publish_date_text_input_edit_text));
    }

    public Matcher<View> ButtonAgreement() {
        return allOf(withId(android.R.id.button1));
    }

    public Matcher<View> ButtonChooseTime() {
        return allOf(withId(R.id.news_item_publish_time_text_input_edit_text));
    }

    public Matcher<View> ButtonDescription() {
        return allOf(withId(R.id.news_item_description_text_input_edit_text));
    }

    public Matcher<View> ButtonSave() {
        return allOf(withId(R.id.save_button));
    }

    public Matcher<View> titleCreate() {
        return allOf(withId(R.id.news_item_title_text_input_edit_text));
    }

    public TimeoutEspresso.TimedViewInteraction newsRecyclerList = timeoutEspresso.onViewWithTimeout(10000, withId(R.id.news_list_recycler_view));

    public ViewInteraction pageControlPanel = onView(withId(R.id.news_list_recycler_view));
}
