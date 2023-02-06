package com.clock.clocks.viewmodels

import androidx.lifecycle.ViewModel
import com.clock.clocks.data.dao.SettingsDao
import com.clock.clocks.data.models.ClockColorModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class CustomClockSettingsViewModel @Inject constructor(val settingsDao:SettingsDao) : ViewModel() {
    fun insertAllDatabase(){
        settingsDao.insertClockColor(ClockColorModel(id = 0, clockColor = "#ffffff"))
    }
    fun getAllFromDatabase():ClockColorModel{
        return settingsDao.getClockColor(settingsDao.getLastProductClockLive().id)
    }
}