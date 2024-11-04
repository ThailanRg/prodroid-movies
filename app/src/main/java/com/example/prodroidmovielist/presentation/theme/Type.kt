package com.example.prodroidmovielist.presentation.theme

import androidx.compose.material3.Typography
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.prodroidmovielist.R

val rajdHaniFamily = FontFamily(
    Font(R.font.rajdhani_light, FontWeight.Light),
    Font(R.font.rajdhani_regular, FontWeight.Normal),
    Font(R.font.rajdhani_medium, FontWeight.Medium),
    Font(R.font.rajdhani_semibold, FontWeight.SemiBold),
    Font(R.font.rajdhani_bold, FontWeight.Bold),
)

val Typography = Typography(
    titleLarge = TextStyle(
        fontFamily = rajdHaniFamily,
        fontWeight = FontWeight.Bold,
        color = Color.White,
        fontSize = 22.sp,
    ),

    bodyLarge = TextStyle(
        fontFamily = rajdHaniFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
        lineHeight = 10.sp,
        color = Color.White,
        letterSpacing = 0.5.sp
    ),
    bodyMedium = TextStyle(
        fontFamily = rajdHaniFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 10.sp,
        lineHeight = 10.sp,
        color = Color.White,
        letterSpacing = 0.5.sp
    ),
    bodySmall = TextStyle(
        fontFamily = rajdHaniFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 10.sp,
        lineHeight = 10.sp,
        color = Color.White,
        letterSpacing = 0.5.sp
    ),

)