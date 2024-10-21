package ru.iteco.fmhandroid.ui.elements;


import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import androidx.test.espresso.ViewInteraction;

import ru.iteco.fmhandroid.R;

public class OurMissionPage {

    public ViewInteraction pageOfOurMission = onView(withId(R.id.our_mission_title_text_view));
}
