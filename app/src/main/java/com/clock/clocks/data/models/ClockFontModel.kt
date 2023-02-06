package com.clock.clocks.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity
data class ClockFontModel(
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    val font:String)