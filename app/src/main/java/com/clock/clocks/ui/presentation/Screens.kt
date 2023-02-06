package com.clock.clocks.ui.presentation

import com.clock.clocks.ui.fragments.CustomClockSettingsFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

object Screens {
    fun customClockSettingsFragment() = FragmentScreen { CustomClockSettingsFragment() }
}