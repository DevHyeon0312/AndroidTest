package com.devhyeon.uitest.main

import android.content.ComponentName
import android.content.Intent
import androidx.test.core.app.ActivityScenario
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import com.devhyeon.uitest.databinding.ActivityMainBinding
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@HiltAndroidTest
class MainActivityHiltTest {
    private lateinit var binding : ActivityMainBinding

    @get:Rule
    var mainActivityRule = HiltAndroidRule(this)

    @Before
    fun init() {
        val mainActivityIntent = Intent.makeMainActivity(
            ComponentName(
                ApplicationProvider.getApplicationContext(),
                MainActivity::class.java,
            )
        )
        ActivityScenario.launch<MainActivity>(mainActivityIntent).onActivity { binding = it.binding }
        mainActivityRule.inject()
    }

    @Test
    fun textChange() {
        onView(ViewMatchers.withId(binding.button.id))
            .perform(ViewActions.click())
        onView(ViewMatchers.withId(binding.textView.id))
            .check(ViewAssertions.matches(ViewMatchers.withText("DevHyeon")))
    }
}