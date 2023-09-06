package com.curso.android.app.practica.cuadradofinal.view

import androidx.test.runner.AndroidJUnit4
import androidx.test.espresso.Espresso
import androidx.test.espresso.ViewAssertion
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.rules.ActivityScenarioRule
import com.curso.android.app.practica.cuadradofinal.R
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @get: Rule
    var rule: ActivityScenarioRule<*> = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun mainActivity_compareButton() {
        Espresso.onView(
            ViewMatchers.withId(R.id.result_button)
        ).perform(
            ViewActions.click()
        )

        Espresso.onView(
            ViewMatchers.withId(R.id.text_result)
        ).check(
            ViewAssertions.matches(
                ViewMatchers.withText("Los textos son iguales")
            )
        )
    }
}