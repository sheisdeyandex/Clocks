package com.clock.clocks.ui.presentation

import com.clock.clocks.data.models.*
import com.clock.clocks.ui.fragments.CustomClockSettingsFragment
import com.clock.clocks.ui.fragments.MainClockFragment
import com.github.terrakok.cicerone.androidx.FragmentScreen

object Screens {
    fun customClockSettingsFragment(clockColorModel: ClockColorModel,
                                    backgroundModel: BackgroundModel,
                                    clockFontModel: ClockFontModel,
                                    clockOrientation: ClockOrientation,
                                    whenPortraitModeModel: WhenPortraitModeModel,
                                    use24HourFormat: Use24HourFormat,
                                    showLeadingZeroForHoursModel: ShowLeadingZeroForHoursModel,
                                    seperatorStyleModel: SeperatorStyleModel,
                                    showWeatherStyleInformationModel: ShowWeatherStyleInformationModel,
                                    clockAppearanceModel: ClockAppearanceModel,
                                    nightModeModel: NightModeModel,
                                    showSecondsModel: ShowSecondsModel,
                                    showDateModel: ShowDateModel,
                                    showDayModel: ShowDayModel,
                                    showDayNameModel: ShowDayNameModel,
                                    hideStatusBarModel: HideStatusBarModel,
                                    automaticallyHideModel: AutomaticallyHideModel,
                                    ) = FragmentScreen {
        CustomClockSettingsFragment(clockColorModel,
            backgroundModel,
            clockFontModel,
            clockOrientation,
            whenPortraitModeModel,
            use24HourFormat,
            showLeadingZeroForHoursModel,
            seperatorStyleModel,
            showWeatherStyleInformationModel,
            clockAppearanceModel,
            nightModeModel,
            showSecondsModel,
            showDateModel,
            showDayModel,
            showDayNameModel,
            hideStatusBarModel,
            automaticallyHideModel
    ) }
    fun mainCustomClockFragment() = FragmentScreen { MainClockFragment() }
}