package com.clock.clocks.domain

import android.content.Context
import androidx.core.content.ContextCompat
import com.clock.clocks.R

object IntegerToHexColor {
    fun toHex(color: Int,context: Context): String {
        return "#${Integer.toHexString(ContextCompat.getColor(context, color))}"
    }
}