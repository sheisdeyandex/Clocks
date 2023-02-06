package com.clock.clocks.data.models

data class SettingsModel (
    val clockColor:String,
    val background:String,
    val clockFont:String,
    val clockOrientation:String,
    val whenInPortraitMode:Boolean,
    val use24HourFormat:Boolean,
    val showAmAndPm:Boolean,
    val showLeadingZeroForHours:Boolean,
    val seperatorStyle:Boolean
    )