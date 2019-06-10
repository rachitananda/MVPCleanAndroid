package com.example.mvpdemo.login;

import android.support.test.espresso.Espresso;
import android.support.test.rule.ActivityTestRule;

import com.example.mvpdemo.R;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.*;

public class MainActivityTest {

    @Rule //to  launch activity
   public ActivityTestRule<MainActivity> activityTestRule =
            new ActivityTestRule<MainActivity>(MainActivity.class);
    private String name ="tony";
    private String lastName="stark";


    @Before//init before test case
    public void setUp() throws Exception {
    }


    @Test
    public void testUserInput(){
     //input view
     Espresso.onView(withId(R.id.first_name_tv)).perform(typeText(name));
     Espresso.onView(withId(R.id.last_name_tv)).perform(typeText(lastName));
     //close keyboard
     Espresso.closeSoftKeyboard();
     //click button
     Espresso.onView(withId(R.id.login_button)).perform(click());
     Espresso.onView(withId(R.id.name_tv)).check(matches(withText(name+" "+lastName)));

    }

    @After//clear resources after test execution finished
    public void tearDown() throws Exception {
    }
}