package ru.iteco.fmhandroid.ui.elements;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.allOf;

import android.view.View;

import androidx.test.espresso.ViewInteraction;

import org.hamcrest.Matcher;

import ru.iteco.fmhandroid.R;

public class NewsPage {

    public ViewInteraction pageOfNews = onView(withId(R.id.all_news_cards_block_constraint_layout));

    public Matcher<View> buttonEditNews() {
        return allOf(withId(R.id.edit_news_material_button));
    }
}
