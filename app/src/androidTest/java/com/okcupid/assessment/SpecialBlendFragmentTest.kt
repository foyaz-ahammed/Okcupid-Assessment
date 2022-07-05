package com.okcupid.assessment

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.core.app.ActivityScenario
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.okcupid.assessment.activities.MainActivity
import com.okcupid.assessment.extensions.isDisplayed
import com.okcupid.assessment.extensions.isNotDisplayed
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class SpecialBlendFragmentTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    @Test
    fun testViews() {
        ActivityScenario.launch(MainActivity::class.java)
        R.id.progressBar.isDisplayed()
        R.id.recyclerview.isNotDisplayed()
        R.id.error_views.isNotDisplayed()
    }
}