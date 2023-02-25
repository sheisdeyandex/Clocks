package com.clock.clocks.viewmodels

import android.content.Context
import androidx.lifecycle.ViewModel
import com.clock.clocks.R
import com.clock.clocks.data.dao.SettingsDao
import com.clock.clocks.data.models.*
import com.clock.clocks.domain.IntegerToHexColor
import com.clock.clocks.usecases.Constants
import dagger.hilt.android.lifecycle.HiltViewModel
import java.sql.Struct
import javax.inject.Inject

@HiltViewModel
class MainClockViewModel @Inject constructor(val settingsDao: SettingsDao): ViewModel() {
    lateinit var date:String
    lateinit var color:String
    lateinit var background:String
    var applyFontToClockOnly:Boolean = false
    var font:Int = R.font.font
    var use24HourFormat:Boolean = true
    var showSeperator:Boolean = true
    var showAmAndPm:Boolean = true
    var showSeconds:Boolean = true
    fun insertAllDatabase(context:Context){
        settingsDao.insertClockColor(ClockColorModel(id = 0, clockColor = IntegerToHexColor.toHex(R.color.red,context),context.getString(R.string.red)))
        settingsDao.insertBackground(BackgroundModel(id = 0, background = IntegerToHexColor.toHex(R.color.black,context),context.getString(R.string.black)))
        settingsDao.insertClockFont(ClockFontModel(id = 0,R.font.roboto,context.getString(R.string.default_name),false))
        settingsDao.insertClockOrientation(ClockOrientation(id=0,Constants.automatic))
        settingsDao.insertUse24HourFormat(Use24HourFormat(id=0,
            use24HourFormat = true,
            showAmAndPm = true))
        settingsDao.insertShowWeatherStyleInformationModel(ShowWeatherStyleInformationModel(id=0,false))
        settingsDao.insertClockAppearanceModel(ClockAppearanceModel(id = 0,false))
        settingsDao.insertNightModeModel(NightModeModel(id=0,false))
        settingsDao.insertSeperatorStyleModel(SeperatorStyleModel(id = 0,
            seperatorStyle = true,
            showSeperatorWhenInLandScape = false,
            showSeperatorWhenInPortrait = false))
        settingsDao.insertShowDateModel(ShowDateModel(id = 0,false))
        settingsDao.insertShowDayModel(ShowDayModel(id = 0,false))
        settingsDao.insertShowSecondsModel(ShowSecondsModel(id = 0,true))
    }
    fun getClockColor():ClockColorModel{
        return settingsDao.getClockColor(settingsDao.getLastProductClockLive().id)
    }
    fun getBackground():BackgroundModel{
        return settingsDao.getBackgroundColor(settingsDao.getLastProductClockLive().id)
    }
    fun getClockFont():ClockFontModel{
        return settingsDao.getClockFontModel(settingsDao.getLastProductClockLive().id)
    }
    fun getUse24HourFormat():Use24HourFormat{
        return settingsDao.getUse24HourFormat(settingsDao.getLastProductClockLive().id)
    }
    fun getSeperator():SeperatorStyleModel{
        return settingsDao.getSeperatorStyleModel(settingsDao.getLastProductClockLive().id)
    }
    fun getShowSeconds():ShowSecondsModel{
        return settingsDao.getShowSecondsModel(settingsDao.getLastProductClockLive().id)
    }
//    fun generateColor(context: Context) {
//        settingsDao.insertClockColor(ClockColorModel(id = 0, clockColor = (R.color.red).toString(),context.getString(R.string.red)))
//    }
//
//    fun getColor(id:Int):String{
//        return settingsDao.getClockColor(id).clockColor
//    }
//    fun getId():Int{
//        return settingsDao.getLastProductClockLive().id
//    }
//
//    fun generateBackground(context: Context) {
//        settingsDao.insertBackground(BackgroundModel(id = 0, IntegerToHexColor.toHex(R.color.black),context.getString(R.string.black)))
//    }
//
//    fun getBackground(id:Int):String{
//        return settingsDao.getBackgroundColor(id).background
//    }
//
//    fun generateClockOrientation() {
//        settingsDao.insertClockOrientation(ClockOrientation(id = 0, Constants.automatic))
//    }
//    fun getClockOrientation(id:Int):String{
//      return  settingsDao.getClockOrientation(id).orientation
//    }
//
//
//    fun generateWhenPortraitModeModel(){settingsDao.insertWhenPortraitModeModel(
//        WhenPortraitModeModel(id=0, true)
//    )}
//
//    fun getWhenPortraitModeModel(id:Int):Boolean{
//        return settingsDao.getWhenPortraitModeModel(id).whenPortraitMode
//    }
//
//    fun generateUse24HourFormat(){settingsDao.insertUse24HourFormat(Use24HourFormat(
//        id=0,
//        use24HourFormat = true,
//        showAmAndPm = true
//    ))}
//
//    fun getUse24HourFormat(id:Int){
//        settingsDao.getUse24HourFormat(id)
//    }
//    fun generateShowLeadingZeroForHoursModel()
//    {settingsDao.insertShowLeadingZeroForHoursModel(
//        ShowLeadingZeroForHoursModel(id=0, true,)
//    )}
//
//    fun getShowLeadingZeroForHoursModel(id:Int){
//        settingsDao.getShowLeadingZeroForHoursModel(id)
//    }
//    fun generateSeparatorStyle()
//    {settingsDao.insertSeperatorStyleModel(
//        SeperatorStyleModel(
//            id=0,
//            seperatorStyle = true,
//            showSeperatorWhenInLandScape = true,
//            showSeperatorWhenInPortrait = true
//
//        )
//    )}
//
//    fun getSeparatorStyle(id:Int){
//        settingsDao.getSeperatorStyleModel(id)
//    }
//    fun generateShowWeatherStyleInformationModel(){settingsDao.insertShowWeatherStyleInformationModel(ShowWeatherStyleInformationModel(id=0,
//        true))}
//
//
//    fun getShowWeatherStyleInformationModel(id:Int){
//        settingsDao.getShowWeatherStyleInformationModel(id)
//    }
//    fun generateClockAppearance(){settingsDao.insertClockAppearanceModel(ClockAppearanceModel(id=0,true))}
//
//    fun getClockAppearance(id:Int){
//        settingsDao.getClockAppearanceModel(id)
//    }
//    fun generateNightModeModel(){settingsDao.insertNightModeModel(NightModeModel(id=0,true))}
//
//    fun getNightModeModel(id:Int){
//        settingsDao.getNightModeModel(id)
//    }
//
//
//    fun generateShowSecondsModel(){settingsDao.insertShowSecondsModel(ShowSecondsModel(id=0, true))}
//
//    fun getShowSecondsModel(id:Int){
//        settingsDao.getShowSecondsModel(id)
//    }
//    fun generateShowDateModel(){settingsDao.insertShowDateModel(ShowDateModel(id=0, true))}
//
//    fun getShowDateModel(id:Int){
//        settingsDao.getShowDateModel(id)
//    }
////    fun generateDateFormatModel(){settingsDao.insertDateFormatModel(DateFormatModel(id=0,
////        DateFormatListModel("")  ))}
////
////    fun getDateFormatModel(id:Int){
////        settingsDao.getDateFormatModel(id)
////    }
////    fun generateShowDayModel(){settingsDao.insertShowDayModel(ShowDayModel(id=0,true))}
////
////    fun getShowDayModel(id:Int){
////        settingsDao.getShowDayModel(id)
////    }
//    fun generateShowDayNameModel(){settingsDao.insertShowDayNameModel(ShowDayNameModel(id=0, true))}
//
//    fun getShowDayNameModel(id:Int){
//        settingsDao.getShowDayNameModel(id)
//    }
//    fun generateHideStatusBarModel(){settingsDao.insertHideStatusBarModel(HideStatusBarModel(id=0,true))}
//
//    fun getHideStatusBarModel(id:Int){
//        settingsDao.getHideStatusBarModel(id)
//    }
//    fun generateAutomaticallyHideModel(){settingsDao.insertAutomaticallyHideModel(
//        AutomaticallyHideModel(id=0,true)
//    )}
//
//    fun getAutomaticallyHideModel(id:Int){
//        settingsDao.getAutomaticallyHideModel(id)
//    }
//    fun generateSetLanguageModel(){settingsDao.insertSetLanguageModel(SetLanguageModel(id=0, true))}
//
//    fun getSetLanguageModel(id:Int){
//        settingsDao.getSetLanguageModel(id)
//    }
}

