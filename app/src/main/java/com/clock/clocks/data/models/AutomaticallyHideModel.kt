package com.clock.clocks.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity
data class AutomaticallyHideModel(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val automaticallyHideModel: Boolean
)
