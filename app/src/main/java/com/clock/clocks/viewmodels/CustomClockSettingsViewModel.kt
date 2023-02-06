package com.clock.clocks.viewmodels

import androidx.lifecycle.ViewModel
import com.clock.clocks.data.dao.SettingsDao
import com.clock.clocks.data.database.AppModule
import com.clock.clocks.data.models.ClockColorModel
import com.clock.clocks.ui.presentation.view.SwitchTextViewController
import dagger.hilt.android.lifecycle.HiltViewModel
import java.time.Clock
import javax.inject.Inject

@HiltViewModel
class CustomClockSettingsViewModel @Inject constructor(val settingsDao:SettingsDao) : ViewModel() {
    fun insertAllDatabase(){
        settingsDao.insertClockColor(ClockColorModel(id = 0, clockColor = "#ffffff"))
    }
    fun getAllFromDatabase():ClockColorModel{
        return settingsDao.getClockColor(settingsDao.getLastProductLive().id)
    }
}