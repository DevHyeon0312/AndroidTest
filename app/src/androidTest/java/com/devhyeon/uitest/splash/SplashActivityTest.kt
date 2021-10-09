package com.devhyeon.uitest.splash

import android.content.ComponentName
import android.content.Intent
import androidx.test.core.app.ActivityScenario
import androidx.test.core.app.ApplicationProvider
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.devhyeon.uitest.databinding.ActivitySplashBinding
import androidx.test.espresso.matcher.ViewMatchers.*
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import org.hamcrest.Matchers
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@HiltAndroidTest
@RunWith(AndroidJUnit4::class)
class SplashActivityTest {
    private lateinit var binding : ActivitySplashBinding
    private lateinit var splashActivityIntent : Intent

    @get:Rule
    var splashActivityRule = HiltAndroidRule(this)

    @Before
    fun init() {
        splashActivityIntent = Intent.makeMainActivity(
            ComponentName(
                ApplicationProvider.getApplicationContext(),
                SplashActivity::class.java,
            )
        )
        ActivityScenario.launch<SplashActivity>(splashActivityIntent).onActivity { binding = it.binding }
        splashActivityRule.inject()
    }

    @Test
    fun startTestCase() {
        checkFullScreen()
        checkShowProgress()
    }

    @After
    fun endTestCode() {

    }

    /**
     * ko. ProgressBar 가 보이는지 확인
     * en. Check if you can see Progress Bar.
     * */
    private fun checkShowProgress() {
        onView(withId(binding.progressBar.id))
            .check(ViewAssertions.matches(isDisplayed()))
    }

    /**
     * ko. FullScreen 인지 확인
     * en. Check if it's the full screen.
     * */
    private fun checkFullScreen() {
        doesNotExistStatusBar()
        doesNotActionBar()
    }

    /**
     * ko. StatusBar 가 존재하지 않는지 확인
     * en. Check if StatusBar doesn't exist.
     * */
    private fun doesNotExistStatusBar() {
        onView(
            Matchers.allOf(
                withId(android.R.id.statusBarBackground),
                isDisplayed()
            )
        ).check(ViewAssertions.doesNotExist())
    }

    /**
     * ko. ActionBar 가 존재하지 않는지 확인
     * en. Check if ActionBar doesn't exist.
     * */
    private fun doesNotActionBar() {
        onView(
            Matchers.allOf(
                withId(android.R.id.title),
                isDisplayed()
            )
        ).check(ViewAssertions.doesNotExist())
    }
}