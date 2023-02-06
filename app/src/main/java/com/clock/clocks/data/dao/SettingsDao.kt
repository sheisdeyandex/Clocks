package com.clock.clocks.data.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.clock.clocks.data.models.BackgroundModel
import com.clock.clocks.data.models.ClockColorModel

@Dao
interface SettingsDao {
    @Insert
    fun insertClockColor(clockColorModel: ClockColorModel)
    @Query("SELECT * FROM clockColorModel WHERE id=:id")
    fun getClockColor(id: Int): ClockColorModel

    @Query("SELECT * FROM clockColorModel ORDER BY id DESC LIMIT 1")
    fun getLastProductLive(): ClockColorModel
    @Insert
    fun insertBackground(backgroundModel: BackgroundModel)
}