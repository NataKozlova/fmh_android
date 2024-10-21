package ru.iteco.fmhandroid.ui.elements;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;

public class MainPaige {

    public ViewInteraction logoEnter = onView(withId(R.id.trademark_image_view));
    public ViewInteraction iconMenuButton = onView(withId(R.id.main_menu_image_button));
    public ViewInteraction newsMenuButton = onView(withText("News"));
    public ViewInteraction aboutMenuButton = onView(withText("About"));
    public ViewInteraction iconOurMissionButton = onView(withId(R.id.our_mission_image_button));
    public ViewInteraction iconAuthButton = onView(withId(R.id.authorization_image_button));
    public ViewInteraction logoutMenuButton = onView(withText("Log out"));
}
