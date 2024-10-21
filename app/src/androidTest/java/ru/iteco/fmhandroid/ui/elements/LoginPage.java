package ru.iteco.fmhandroid.ui.elements;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withHint;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;

import android.view.View;

import androidx.test.espresso.ViewInteraction;

import org.hamcrest.core.IsInstanceOf;

import ru.iteco.fmhandroid.R;

public class LoginPage {

    public ViewInteraction loginField = onView(allOf(withHint("Login"),
            withParent(withParent(withId(R.id.login_text_input_layout)))));
    public ViewInteraction passwordField = onView(allOf(withHint("Password"),
            withParent(withParent(withId(R.id.password_text_input_layout)))));
    public ViewInteraction buttonSign = onView(allOf(withId(R.id.enter_button),
            withText("SIGN IN"), withContentDescription("Save"),
            withParent(withParent(IsInstanceOf.<View>instanceOf(android.widget.RelativeLayout.class)))));
    public ViewInteraction pageAuthorization = onView(allOf(withText("Authorization")));
}
