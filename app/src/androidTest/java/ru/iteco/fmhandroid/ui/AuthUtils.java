package ru.iteco.fmhandroid.ui;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.replaceText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withClassName;
import static androidx.test.espresso.matcher.ViewMatchers.withContentDescription;
import static androidx.test.espresso.matcher.ViewMatchers.withHint;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withParent;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import androidx.test.espresso.NoMatchingViewException;
import androidx.test.espresso.ViewInteraction;

import junit.framework.AssertionFailedError;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.hamcrest.core.IsInstanceOf;

import io.qameta.allure.kotlin.Step;
import ru.iteco.fmhandroid.R;

public class AuthUtils {

    WaitingUtils waitingUtils = new WaitingUtils();

    ViewInteraction loginTextInput = onView(allOf(withHint("Login"),
            withParent(withParent(withId(R.id.login_text_input_layout)))));
    ViewInteraction passwordTextInput = onView(allOf(withHint("Password"),
            withParent(withParent(withId(R.id.password_text_input_layout)))));
    ViewInteraction enterButton = onView(allOf(withId(R.id.enter_button),
            withText("SIGN IN"), withContentDescription("Save"),
            withParent(withParent(IsInstanceOf.<View>instanceOf(android.widget.RelativeLayout.class)))));

    ViewInteraction iconLogOut = onView(
            allOf(withId(R.id.authorization_image_button), withContentDescription("Authorization"),
                    childAtPosition(
                            allOf(withId(R.id.container_custom_app_bar_include_on_fragment_main),
                                    childAtPosition(
                                            withClassName(is("android.widget.LinearLayout")),
                                            0)),
                            5)));

    ViewInteraction logOutTextView = onView(
            allOf(withId(android.R.id.title), withText("Log out"),
                    childAtPosition(
                            childAtPosition(
                                    withId(android.R.id.content),
                                    0),
                            0)));

    ViewInteraction pageAuthorization = onView(allOf(withText("Authorization")));

    @Step("Выполняем вход с данными по умолчанию")
    public void login() {
        try {
            waitingUtils.waiting(5000);

            enterLogin("login2");
            enterPassword("password2");
            clickSignInButton();
        } catch (NoMatchingViewException | AssertionFailedError e) {
            System.out.println("iconLogOut не найден. Пропустить.");
        }
    }

    @Step("Выполняем вход с логином: {0} и паролем: {1}")
    public void login(String login, String password) {
        try {
            waitingUtils.waiting(5000);

            enterLogin(login);
            enterPassword(password);
            clickSignInButton();
        } catch (NoMatchingViewException | AssertionFailedError e) {
            System.out.println("iconLogOut не найден. Пропустить.");
        }
    }

    @Step("Выполняем выход из аккаунта")
    public void logout() {
        try {
            waitingUtils.waiting(5000);
            iconLogOut.check(matches(isDisplayed()));
            iconLogOut.perform(click());

            waitingUtils.waiting(1500);

            logOutTextView.check(matches(isDisplayed()));
            logOutTextView.perform(click());

            pageAuthorization.check(matches(isDisplayed()));
        } catch (NoMatchingViewException | AssertionFailedError e) {
            System.out.println("iconLogOut не найден. Пропустить.");
        }
    }

    @Step("Вводим логин: {0}")
    private void enterLogin(String login) {
        loginTextInput.check(matches(isDisplayed()));
        loginTextInput.perform(click());
        loginTextInput.perform(replaceText(login), closeSoftKeyboard());
    }

    @Step("Вводим пароль: {0}")
    private void enterPassword(String password) {
        passwordTextInput.check(matches(isDisplayed()));
        passwordTextInput.perform(click());
        passwordTextInput.perform(replaceText(password), closeSoftKeyboard());
    }

    @Step("Нажимаем на кнопку 'Войти'")
    private void clickSignInButton() {
        enterButton.perform(click());
    }

    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }
}
