package com.clock.clocks.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.clock.clocks.data.dao.SettingsDao
import com.clock.clocks.data.models.*

@Database(entities = [BackgroundModel::class,ClockColorModel::class,ClockAppearanceModel::class,ClockFontModel::class, AutomaticallyHideModel::class,ClockOrientation::class,HideStatusBarModel::class,NightModeModel::class,SeperatorStyleModel::class,SetLanguageModel::class,ShowDateModel::class,ShowDayModel::class,ShowDayNameModel::class,ShowLeadingZeroForHoursModel::class,ShowSecondsModel::class,ShowWeatherStyleInformationModel::class,Use24HourFormat::class,WhenPortraitModeModel::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun settingDao(): SettingsDao
}