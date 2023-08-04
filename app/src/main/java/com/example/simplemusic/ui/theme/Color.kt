package com.example.simplemusic.ui.theme

import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color

val Purple80 = Color(0xFFD0BCFF)
val PurpleGrey80 = Color(0xFFCCC2DC)
val Pink80 = Color(0xFFEFB8C8)

val Purple40 = Color(0xFF6650a4)
val PurpleGrey40 = Color(0xFF625b71)
val Pink40 = Color(0xFF7D5260)

val GrayDisable = Color(0xff515052)
val BaseBlack = Color(0XFF1B1B1B)
val PinkEnable= Color(0xff7A38E7)
val whiteEF = Color(0xfffefefe)
val grayE3 = Color(0xffe3e3e3)

val magenta1 = Color(0xff4C14A8)
val magenta2 = Color(0xff7244BF)
val green1 = Color(0xff295F51)
val green2 = Color(0xff487369)
val orange1 = Color(0xffA46610)
val orange2 = Color(0xffCC8D37)

val DarkColors = darkColorScheme(
    onPrimaryContainer = GrayDisable, onBackground = whiteEF,
    onSurface = GrayDisable, secondary = PinkEnable, primary = BaseBlack, surface = GrayDisable
)
val LightColors = lightColorScheme(
    onPrimaryContainer = grayE3,
    onSurface = grayE3, secondary = PinkEnable, primary = whiteEF, surface =  grayE3
)