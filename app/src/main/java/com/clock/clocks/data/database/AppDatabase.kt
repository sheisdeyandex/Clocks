package com.clock.clocks.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.clock.clocks.data.dao.SettingsDao
import com.clock.clocks.data.models.BackgroundModel
import com.clock.clocks.data.models.ClockColorModel

@Database(entities = [BackgroundModel::class,ClockColorModel::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun settingDao(): SettingsDao
}