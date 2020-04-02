package com.amlwin.fragment_basic

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.lifecycle.Lifecycle
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withText
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

/**
 * a touch of amlwin on 02/04/2020.
 * made with <3
 */
@RunWith(AndroidJUnit4::class)
class MainFragmentTest {

    private lateinit var targetContext: Context

    @Before
    fun setUp() {
        targetContext = InstrumentationRegistry.getInstrumentation().targetContext
    }

    @Test
    fun testMainFragment() {
        val fragmentFactory = MainFragmentFactory()
        val bundle = Bundle()
        bundle.putString(
            MainFragment.key_title,
            targetContext.resources.getString(R.string.title_main_fragment)
        )
        val scenario =
            launchFragmentInContainer<MainFragment>(
                fragmentArgs = bundle,
                factory = fragmentFactory
            )

        scenario.moveToState(Lifecycle.State.RESUMED)
        onView(withText(R.string.title_main_fragment)).check(matches(isDisplayed()))

    }
}