package com.clock.clocks.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity
data class Use24HourFormat(
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    val use24HourFormat:Boolean,val showAmAndPm:Boolean)
