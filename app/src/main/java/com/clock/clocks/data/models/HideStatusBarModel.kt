package com.clock.clocks.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity
data class HideStatusBarModel(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val hideStatusBarModel: Boolean
)
