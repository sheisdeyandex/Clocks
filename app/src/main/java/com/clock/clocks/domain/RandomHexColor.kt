package com.clock.clocks.domain

import java.util.*

object RandomHexColor {
    fun getRandomHexColor(): String {
        val random = Random()
        val red = random.nextInt(256)
        val green = random.nextInt(256)
        val blue = random.nextInt(256)
        return String.format("#%02X%02X%02X", red, green, blue)
    }
}