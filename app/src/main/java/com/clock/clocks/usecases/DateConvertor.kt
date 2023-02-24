package com.clock.clocks.usecases

import java.text.SimpleDateFormat
import java.util.*

object DateConvertor {
    fun getDate(format:String):String{
        return SimpleDateFormat(format, Locale.getDefault()).format(Date())
    }
    fun getHours(format:String):String{
        return SimpleDateFormat(format, Locale.getDefault()).format(Date())
    }
}