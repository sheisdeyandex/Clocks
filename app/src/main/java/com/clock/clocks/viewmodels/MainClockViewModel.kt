package com.clock.clocks.viewmodels

import android.content.Context
import androidx.lifecycle.ViewModel
import com.clock.clocks.R
import com.clock.clocks.data.dao.SettingsDao
import com.clock.clocks.data.models.*
import com.clock.clocks.domain.IntegerToHexColor
import com.clock.clocks.usecases.Constants
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainClockViewModel @Inject constructor(val settingsDao: SettingsDao): ViewModel() {
    lateinit var date:String
    lateinit var color:String
    lateinit var background:String
    var applyFontToClockOnly:Boolean = false
    var font:Int = R.font.font
    var orientation=Constants.automatic
    var whenInPortraitMode = false
    var use24HourFormat:Boolean = true
    var showLeadingZeroForHours:Boolean = true
    var showSeperator:Boolean = true
    var showWeatherStyleInformation: Boolean = false
    var clockAppearance: Boolean = false
    var nightMode: Boolean = false
    var showAmAndPm:Boolean = true
    var showSeconds:Boolean = true
    var showDate:Boolean = false
    var showDay: Boolean = false
    var showDayName: Boolean = false
    var hideStatusBar: Boolean = true
    var automaticallyHide: Boolean = false
    lateinit var clockColorModel: ClockColorModel
    lateinit var backgroundModel: BackgroundModel
    lateinit var clockFontModel: ClockFontModel
    lateinit var clockOrientation: ClockOrientation
    lateinit var whenPortraitModeModel: WhenPortraitModeModel
    lateinit var use24HourFormatModel: Use24HourFormat
    lateinit var showLeadingZeroForHoursModel: ShowLeadingZeroForHoursModel
    lateinit var seperatorStyleModel: SeperatorStyleModel
    lateinit var showWeatherStyleInformationModel: ShowWeatherStyleInformationModel
    lateinit var clockAppearanceModel: ClockAppearanceModel
    lateinit var nightModeModel: NightModeModel
    lateinit var showSecondsModel: ShowSecondsModel
    lateinit var showDateModel: ShowDateModel
    lateinit var showDayModel: ShowDayModel
    lateinit var showDayNameModel: ShowDayNameModel
    lateinit var hideStatusBarModel: HideStatusBarModel
    lateinit var automaticallyHideModel: AutomaticallyHideModel


    fun insertAllDatabase(context:Context){
        settingsDao.insertClockColor(ClockColorModel(id = 0, clockColor = IntegerToHexColor.toHex(R.color.red,context),context.getString(R.string.red)))
        settingsDao.insertBackground(BackgroundModel(id = 0, background = IntegerToHexColor.toHex(R.color.black,context),context.getString(R.string.black)))
        settingsDao.insertClockFont(ClockFontModel(id = 0,R.font.roboto,context.getString(R.string.default_name),false))
        settingsDao.insertClockOrientation(ClockOrientation(id=0,Constants.automatic))
        settingsDao.insertWhenPortraitModeModel(WhenPortraitModeModel(id=0,true))
        settingsDao.insertUse24HourFormat(Use24HourFormat(id=0,
            use24HourFormat = true,
            showAmAndPm = true))
        settingsDao.insertShowLeadingZeroForHoursModel(ShowLeadingZeroForHoursModel(id=0,true))
        settingsDao.insertSeperatorStyleModel(SeperatorStyleModel(id = 0,
            seperatorStyle = true,
            showSeperatorWhenInLandScape = false,
            showSeperatorWhenInPortrait = false))
        settingsDao.insertShowWeatherStyleInformationModel(ShowWeatherStyleInformationModel(id=0,false))
        settingsDao.insertClockAppearanceModel(ClockAppearanceModel(id = 0,false))
        settingsDao.insertNightModeModel(NightModeModel(id=0,false))
        settingsDao.insertShowSecondsModel(ShowSecondsModel(id = 0,true))
        settingsDao.insertShowDateModel(ShowDateModel(id = 0,false))
  //      settingsDao.insertDateFormatModel(DateFormatModel(id = ))
        settingsDao.insertShowDayModel(ShowDayModel(id = 0,false))
        settingsDao.insertShowDayNameModel(ShowDayNameModel(id=0,false))
        settingsDao.insertHideStatusBarModel(HideStatusBarModel(id=0,true))
        settingsDao.insertAutomaticallyHideModel(AutomaticallyHideModel(id=0,false))
    }
    fun getClockColor():ClockColorModel{
        clockColorModel =settingsDao.getClockColor(settingsDao.getLastProductClockLive().id)
        return clockColorModel
    }
    fun getBackground():BackgroundModel{
        return settingsDao.getBackgroundColor(settingsDao.getLastProductClockLive().id)
    }
    fun getClockFont():ClockFontModel{
        return settingsDao.getClockFontModel(settingsDao.getLastProductClockLive().id)
    }
    fun getWhenInPortraitMode():WhenPortraitModeModel{
        return settingsDao.getWhenPortraitModeModel(settingsDao.getLastProductClockLive().id)
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
    fun getShowWeatherStyleInformation():ShowWeatherStyleInformationModel{
        return settingsDao.getShowWeatherStyleInformationModel(settingsDao.getLastProductClockLive().id)
    }
    fun getShowLeadingZeroForHours():ShowLeadingZeroForHoursModel{
        return settingsDao.getShowLeadingZeroForHoursModel(settingsDao.getLastProductClockLive().id)
    }
    fun getClockAppearance():ClockAppearanceModel{
        return settingsDao.getClockAppearanceModel(settingsDao.getLastProductClockLive().id)
    }
    fun getNightMode():NightModeModel{
        return settingsDao.getNightModeModel(settingsDao.getLastProductClockLive().id)
    }
    fun getShowDate():ShowDateModel{
        return settingsDao.getShowDateModel(settingsDao.getLastProductClockLive().id)
    }
    fun getShowDay():ShowDayModel{
        return settingsDao.getShowDayModel(settingsDao.getLastProductClockLive().id)
    }
    fun getShowDayName():ShowDayNameModel{
        return settingsDao.getShowDayNameModel(settingsDao.getLastProductClockLive().id)
    }
    fun getHideStatusBar():HideStatusBarModel{
        return settingsDao.getHideStatusBarModel(settingsDao.getLastProductClockLive().id)
    }
    fun getAutomaticallyHide():AutomaticallyHideModel{
        return settingsDao.getAutomaticallyHideModel(settingsDao.getLastProductClockLive().id)
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

