package com.clock.clocks.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.clock.clocks.R
import com.clock.clocks.core.App
import com.clock.clocks.ui.presentation.Screens
import com.github.terrakok.cicerone.androidx.AppNavigator
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val navigator = AppNavigator(this, R.id.container)

    override fun onResumeFragments() {
        super.onResumeFragments()
        App.INSTANCE.navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        App.INSTANCE.navigatorHolder.removeNavigator()
        super.onPause()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        App.INSTANCE.router.replaceScreen(Screens.mainCustomClockFragment())
    }
}