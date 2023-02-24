package com.clock.clocks.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ClockColorModel(
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    val clockColor: String,
    val name:String
    )