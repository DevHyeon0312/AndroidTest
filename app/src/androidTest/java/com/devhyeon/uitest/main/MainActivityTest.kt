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
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@HiltAndroidTest
class MainActivityTest {
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
    fun startTestCase() {
        defaultTextView()
        buttonClickIsChangeTextView()
    }

    @After
    fun endTestCode() {

    }

    /**
     * ko. 처음 실행했을 때, textView 의 text 가 Default 인지 검사
     * en. When executed for the first time, check whether the text in the textView is default.
     * */
    private fun defaultTextView() {
        onView(ViewMatchers.withId(binding.tvText.id))
            .check(ViewAssertions.matches(ViewMatchers.withText("Default")))
    }

    /**
     * ko. button 을 클릭하면 textView 의 text 가 DevHyeon 으로 변경
     * en. If you click button, text in textView changes to DevHyeon
     * */
    private fun buttonClickIsChangeTextView() {
        onView(ViewMatchers.withId(binding.btnChange.id))
            .perform(ViewActions.click())
        onView(ViewMatchers.withId(binding.tvText.id))
            .check(ViewAssertions.matches(ViewMatchers.withText("DevHyeon")))
    }

}