package com.devhyeon.uitest.main

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.devhyeon.uitest.R
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {
    @get:Rule
    var myActivityActivityTestRule = ActivityScenarioRule<MainActivity>(MainActivity::class.java)

    @Test
    fun textChange() {
        onView(withId(R.id.button)).perform(click())
        onView(withId(R.id.textView)).check(matches(withText("DevHyeon")))
    }
}

