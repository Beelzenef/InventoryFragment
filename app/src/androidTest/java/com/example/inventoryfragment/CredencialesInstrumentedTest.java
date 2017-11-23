package com.example.inventoryfragment;

import android.content.Context;
import android.support.annotation.StringRes;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.matcher.ViewMatchers;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import com.example.inventoryfragment.ui.login.LoginViewImpl;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withEffectiveVisibility;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.assertEquals;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class CredencialesInstrumentedTest {
    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.example.loginlinearlayout", appContext.getPackageName());
    }

    @Rule
    public ActivityTestRule<LoginViewImpl> mainActivityRule =
            new ActivityTestRule<>(LoginViewImpl.class);

    // 1. Usuario introduce username (prueba instrumental, sobre GUI)
    @Test
    public void isUserEmpty() throws Exception {
        onView(withId(R.id.edT_User)).perform(typeText("user"), closeSoftKeyboard());
        onView(withId(R.id.btn_SignIn)).perform(click())
                .check(matches(withText("*{6,}")));
        checkSnackBarDisplayByMessage(R.string.userEmptyError);
    }

    // Usuario introduce email (prueba instrumental, sobre GUI)
    @Test
    public void isEmailEmpty() throws Exception {
        onView(withId(R.id.edT_User)).perform(typeText("user"), closeSoftKeyboard());
        onView(withId(R.id.btn_SignIn)).perform(click())
                .check(matches(withText("([a-z]+[A-Z]+[0-9]+){6,}")));
        checkSnackBarDisplayByMessage(R.string.passwordEmptyError);
    }

    // Usuario introduce passw (prueba instrumental, sobre GUI)
    @Test
    public void isPasswordEmpty() throws Exception {
        onView(withId(R.id.edT_Passw)).perform(typeText("usuario1"), closeSoftKeyboard());
        onView(withId(R.id.btn_SignIn)).perform(click())
                .check(matches(withText("([a-z]+[A-Z]+[0-9]+){6,}")));
        checkSnackBarDisplayByMessage(R.string.passwordEmptyError);
    }

    // Passwd al menos con 6 chars (prueba instrumental, sobre GUI)
    @Test
    public void passwordLenght_isCorrect() throws Exception {
        onView(withId(R.id.edT_Passw)).perform(typeText("usuario1"), closeSoftKeyboard());
        onView(withId(R.id.btn_SignIn)).perform(click())
                .check(matches(withText("([a-z]+[A-Z]+[0-9]+){6,}")));
        checkSnackBarDisplayByMessage(R.string.passwordLengthError);
    }

    // Doble comprobacion de contraseña (prueba instrumental, sobre GUI)
    @Test
    public void passwordDoubleCheck() throws Exception {

    }

    public void checkSnackBarDisplayByMessage(@StringRes int m) {
        onView(withText(m)).check(matches(withEffectiveVisibility(ViewMatchers.Visibility.VISIBLE)));
    }
}
