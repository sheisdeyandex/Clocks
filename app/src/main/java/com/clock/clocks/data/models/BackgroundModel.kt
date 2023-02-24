package com.clock.clocks.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey
@Entity
data class BackgroundModel(
    @PrimaryKey(autoGenerate = true)
    val id:Int,
    val background:String,
    val name:String
)