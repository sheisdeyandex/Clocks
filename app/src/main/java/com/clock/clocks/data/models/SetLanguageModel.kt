package com.clock.clocks.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity
data class SetLanguageModel(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val setLanguageModel:  Boolean
)
