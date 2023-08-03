package com.example.simplemusic.ui.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.simplemusic.R

// Set of Material typography styles to start with
val IconFont = TextStyle(
    fontFamily =  FontFamily(Font(R.font.icons)),
    fontWeight =  FontWeight(400),
    fontSize = 18.sp,
    color = GrayDisable
)

val Typography = Typography(
    bodyLarge = TextStyle(
        fontFamily = FontFamily(Font(R.font.roboto)),
        fontWeight = FontWeight(400),
        fontSize = 18.sp,
        color = whiteEF
    ),
    titleLarge = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight(400),
        fontSize = 20.sp, color = whiteEF
    ),
    labelSmall = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight(400),
        fontSize = 10.sp,
        color = GrayDisable
    ), labelMedium = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight(400),
        fontSize = 12.sp,
        color = GrayDisable)
    , labelLarge =  TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight(400),
        fontSize = 14.sp,
        color = whiteEF)

)