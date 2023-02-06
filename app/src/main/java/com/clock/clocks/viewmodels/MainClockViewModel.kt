package com.clock.clocks.viewmodels

import androidx.lifecycle.ViewModel
import com.clock.clocks.R
import com.clock.clocks.data.dao.SettingsDao
import com.clock.clocks.data.models.*
import com.clock.clocks.usecases.Constants
import dagger.hilt.android.lifecycle.HiltViewModel
import java.sql.Struct
import javax.inject.Inject

@HiltViewModel
class MainClockViewModel @Inject constructor(val settingsDao: SettingsDao): ViewModel() {
    fun generateColor() {
        settingsDao.insertClockColor(ClockColorModel(id = 0, clockColor = (R.color.red).toString()))
    }

    fun getColor(id:Int):String{
        return settingsDao.getClockColor(id).clockColor
    }
    fun getId():Int{
        return settingsDao.getLastProductClockLive().id
    }

    fun generateBackground() {
        settingsDao.insertBackground(BackgroundModel(id = 0, (R.color.black).toString()))
    }

    fun getBackground(id:Int):String{
        return settingsDao.getBackgroundColor(id).background
    }

    fun generateClockOrientation() {
        settingsDao.insertClockOrientation(ClockOrientation(id = 0, Constants.automatic))
    }
    fun getClockOrientation(id:Int):String{
      return  settingsDao.getClockOrientation(id).orientation
    }


    fun generateWhenPortraitModeModel(){settingsDao.insertWhenPortraitModeModel(
        WhenPortraitModeModel(id=0, true)
    )}

    fun getWhenPortraitModeModel(id:Int):Boolean{
        return settingsDao.getWhenPortraitModeModel(id).whenPortraitMode
    }

    fun generateUse24HourFormat(){settingsDao.insertUse24HourFormat(Use24HourFormat(
        id=0,
        use24HourFormat = true,
        showAmAndPm = true
    ))}

    fun getUse24HourFormat(id:Int){
        settingsDao.getUse24HourFormat(id)
    }
    fun generateShowLeadingZeroForHoursModel()
    {settingsDao.insertShowLeadingZeroForHoursModel(
        ShowLeadingZeroForHoursModel(id=0, true,)
    )}

    fun getShowLeadingZeroForHoursModel(id:Int){
        settingsDao.getShowLeadingZeroForHoursModel(id)
    }
    fun generateSeparatorStyle()
    {settingsDao.insertSeperatorStyleModel(
        SeperatorStyleModel(
            id=0,
            seperatorStyle = true,
            showSeperatorWhenInLandScape = true,
            showSeperatorWhenInPortrait = true

        )
    )}

    fun getSeparatorStyle(id:Int){
        settingsDao.getSeperatorStyleModel(id)
    }
    fun generateShowWeatherStyleInformationModel(){settingsDao.insertShowWeatherStyleInformationModel(ShowWeatherStyleInformationModel(id=0,
        true))}


    fun getShowWeatherStyleInformationModel(id:Int){
        settingsDao.getShowWeatherStyleInformationModel(id)
    }
    fun generateClockAppearance(){settingsDao.insertClockAppearanceModel(ClockAppearanceModel(id=0,true))}

    fun getClockAppearance(id:Int){
        settingsDao.getClockAppearanceModel(id)
    }
    fun generateNightModeModel(){settingsDao.insertNightModeModel(NightModeModel(id=0,true))}

    fun getNightModeModel(id:Int){
        settingsDao.getNightModeModel(id)
    }


    fun generateShowSecondsModel(){settingsDao.insertShowSecondsModel(ShowSecondsModel(id=0, true))}

    fun getShowSecondsModel(id:Int){
        settingsDao.getShowSecondsModel(id)
    }
    fun generateShowDateModel(){settingsDao.insertShowDateModel(ShowDateModel(id=0, true))}

    fun getShowDateModel(id:Int){
        settingsDao.getShowDateModel(id)
    }
    fun generateDateFormatModel(){settingsDao.insertDateFormatModel(DateFormatModel(id=0,
        DateFormatListModel("")  ))}

    fun getDateFormatModel(id:Int){
        settingsDao.getDateFormatModel(id)
    }
    fun generateShowDayModel(){settingsDao.insertShowDayModel(ShowDayModel(id=0,true))}

    fun getShowDayModel(id:Int){
        settingsDao.getShowDayModel(id)
    }
    fun generateShowDayNameModel(){settingsDao.insertShowDayNameModel(ShowDayNameModel(id=0, true))}

    fun getShowDayNameModel(id:Int){
        settingsDao.getShowDayNameModel(id)
    }
    fun generateHideStatusBarModel(){settingsDao.insertHideStatusBarModel(HideStatusBarModel(id=0,true))}

    fun getHideStatusBarModel(id:Int){
        settingsDao.getHideStatusBarModel(id)
    }
    fun generateAutomaticallyHideModel(){settingsDao.insertAutomaticallyHideModel(
        AutomaticallyHideModel(id=0,true)
    )}

    fun getAutomaticallyHideModel(id:Int){
        settingsDao.getAutomaticallyHideModel(id)
    }
    fun generateSetLanguageModel(){settingsDao.insertSetLanguageModel(SetLanguageModel(id=0, true))}

    fun getSetLanguageModel(id:Int){
        settingsDao.getSetLanguageModel(id)
    }
}

