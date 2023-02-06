package com.clock.clocks.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity
data class SeperatorStyleModel(
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    val seperatorStyle:Boolean,val showSeperatorWhenInLandScape:Boolean,val showSeperatorWhenInPortrait: Boolean)
