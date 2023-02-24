package com.clock.clocks.viewmodels

import android.content.Context
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModel
import com.clock.clocks.R
import com.clock.clocks.data.dao.SettingsDao
import com.clock.clocks.data.models.*
import com.clock.clocks.usecases.Constants
import com.github.terrakok.cicerone.Back
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CustomClockSettingsViewModel @Inject constructor(private val settingsDao:SettingsDao) : ViewModel() {
    lateinit var clockColor:String
    lateinit var backgroundColor:String
    lateinit var clockFont:String
    lateinit var clockOrientation:String
    var seperatorStyle:Boolean = false
    var showSeperatorWhenInPortrait:Boolean = false
    var showSeperatorWhenInLandscape:Boolean = false
    var weatherInformation:Boolean = false
    var clockAppearance:Boolean = false
    var nightMode:Boolean = false
    var showSeconds:Boolean = false
    var showDate:Boolean = false
    var showDay:Boolean = false
    var showDayNameInFull:Boolean = false
    var hideStatusBar:Boolean = false
    var autoHideSettingIcon:Boolean = false
    fun insertAllDatabase(context:Context){
        settingsDao.insertClockColor(ClockColorModel(id = 0, clockColor = "#ffffff",context.getString(R.string.white)))
        settingsDao.insertBackground(BackgroundModel(id = 0, background = "#ffffff",context.getString(R.string.black)))
        settingsDao.insertClockFont(ClockFontModel(id = 0,R.font.font,context.getString(R.string.default_name),false))
        settingsDao.insertClockOrientation(ClockOrientation(id=0,Constants.automatic))
        insertShowWeatherInformation(true)
        insertClockAppearance(true)
        insertNightMode(false)
        insertSeperatorStyle(seperatorStyle = true,
            showSeperatorWhenInLandscape = true,
            showSeperatorWhenInPortrait = true)
        insertShowDate(true)
        insertShowDay(false)
        insertShowSeconds(false)
    }

    fun insertClockColor(color:String,name:String){
        settingsDao.insertClockColor(ClockColorModel(settingsDao.getLastProductClockLive().id,color,name))
    }

    fun getClockColor():ClockColorModel{
        return settingsDao.getClockColor(settingsDao.getLastProductClockLive().id)
    }

    fun insertBackgroundColor(color:String,name:String){
        settingsDao.insertBackground(BackgroundModel(settingsDao.getLastProductClockLive().id,color,name))
    }

    fun getBackgroundColor():BackgroundModel{
        return settingsDao.getBackgroundColor(settingsDao.getLastProductClockLive().id)
    }

    fun insertFont(font:Int,name:String,applyToClockOnly:Boolean){
        settingsDao.insertClockFont(ClockFontModel(settingsDao.getLastProductClockLive().id,font,name,applyToClockOnly))
    }

    fun getFont():ClockFontModel{
        return settingsDao.getClockFontModel(settingsDao.getLastProductClockLive().id)
    }
    fun insertClockOrientation(orientation:String){
        settingsDao.insertClockOrientation(ClockOrientation(settingsDao.getLastProductClockLive().id,orientation))
    }

    fun getClockOrientation():ClockOrientation{
        return settingsDao.getClockOrientation(settingsDao.getLastProductClockLive().id)
    }
    fun insertWhenInPortraitMode(boolean: Boolean){
        settingsDao.insertWhenPortraitModeModel(WhenPortraitModeModel(settingsDao.getLastProductClockLive().id, whenPortraitMode = boolean))
    }
    fun insertUse24HourFormat(boolean: Boolean,showAmAndPm:Boolean){
        settingsDao.insertUse24HourFormat(Use24HourFormat(settingsDao.getLastProductClockLive().id, use24HourFormat = boolean,showAmAndPm))
    }
    fun insertShowLeadingZeroForHours(boolean: Boolean){
        settingsDao.insertShowLeadingZeroForHoursModel(ShowLeadingZeroForHoursModel(settingsDao.getLastProductClockLive().id, boolean))
    }
    fun insertSeperatorStyle(seperatorStyle: Boolean,showSeperatorWhenInLandscape:Boolean,showSeperatorWhenInPortrait: Boolean){
        settingsDao.insertSeperatorStyleModel(SeperatorStyleModel(settingsDao.getLastProductClockLive().id, seperatorStyle,showSeperatorWhenInLandscape,showSeperatorWhenInPortrait))
    }
    fun getSeperatorStyle():SeperatorStyleModel{
        return settingsDao.getSeperatorStyleModel(settingsDao.getLastProductClockLive().id)
    }
    fun insertShowWeatherInformation(boolean: Boolean){
        settingsDao.insertShowWeatherStyleInformationModel(ShowWeatherStyleInformationModel(settingsDao.getLastProductClockLive().id, boolean))
    }
    fun getWeatherInformation():ShowWeatherStyleInformationModel{
        return settingsDao.getShowWeatherStyleInformationModel(settingsDao.getLastProductClockLive().id)
    }
    fun insertClockAppearance(boolean: Boolean){
        settingsDao.insertClockAppearanceModel(ClockAppearanceModel(settingsDao.getLastProductClockLive().id, boolean))
    }
    fun getClockAppearance():ClockAppearanceModel{
        return settingsDao.getClockAppearanceModel(settingsDao.getLastProductClockLive().id)
    }
    fun insertNightMode(boolean: Boolean){
        settingsDao.insertNightModeModel(NightModeModel(settingsDao.getLastProductClockLive().id, boolean))
    }
    fun getNightMode():NightModeModel{
        return settingsDao.getNightModeModel(settingsDao.getLastProductClockLive().id)
    }
    fun insertShowSeconds(boolean: Boolean){
        settingsDao.insertShowSecondsModel(ShowSecondsModel(settingsDao.getLastProductClockLive().id, boolean))
    }
    fun getShowSeconds():ShowSecondsModel{
        return settingsDao.getShowSecondsModel(settingsDao.getLastProductClockLive().id)
    }
    fun insertShowDate(boolean: Boolean){
        settingsDao.insertShowDateModel(ShowDateModel(settingsDao.getLastProductClockLive().id, boolean))
    }
    fun getShowDate():ShowDateModel{
        return settingsDao.getShowDateModel(settingsDao.getLastProductClockLive().id)
    }
    fun insertShowDay(boolean: Boolean){
        settingsDao.insertShowDayModel(ShowDayModel(settingsDao.getLastProductClockLive().id, boolean))
    }
    fun getShowDay():ShowDayModel{
        return settingsDao.getShowDayModel(settingsDao.getLastProductClockLive().id)
    }
    fun getWhenInPortraitMode():WhenPortraitModeModel{
        return settingsDao.getWhenPortraitModeModel(settingsDao.getLastProductClockLive().id)
    }

}