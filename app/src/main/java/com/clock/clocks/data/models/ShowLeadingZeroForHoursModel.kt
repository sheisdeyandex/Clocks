package com.clock.clocks.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity
data class ShowLeadingZeroForHoursModel (
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    val showLeadingZeroForHours: Boolean)