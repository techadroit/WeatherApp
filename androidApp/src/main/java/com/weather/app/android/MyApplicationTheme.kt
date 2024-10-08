package com.weather.app.android

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Shapes
import androidx.compose.material.Typography
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun MyApplicationTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        darkColors(
            primary = Color(0xFFBB86FC),
            primaryVariant = Color(0xFF3700B3),
            onPrimary = Color(0xFF2A2A2A),
            secondary = Color(0xFF03DAC5),
            onSecondary = Color(0xFF556799),
            surface = Color(0xFFF5F6F7),
            background = Color(0xFFF5F6F7)
        )
    } else {
        lightColors(
            primary = Color(0xFF6200EE),
            primaryVariant = Color(0xFF3700B3),
            onPrimary = Color(0xFF2A2A2A),
            secondary = Color(0xFF03DAC5),
            onSecondary = Color(0xFF556799),
            surface = Color(0xFFF5F6F7),
            background = Color(0xFFF5F6F7)
        )
    }
    val typography = Typography(
        body1 = TextStyle(
            fontFamily = FontFamily.Default,
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp
        ),
        h1 = TextStyle(
            fontWeight = FontWeight.Medium,
            fontSize = 96.sp,
            lineHeight = 112.sp,
            letterSpacing = (-1.5).sp,
        ),
        h4 = TextStyle(
            fontWeight = FontWeight.Thin,
            fontSize = 34.sp,
            lineHeight = 36.sp,
            letterSpacing = 0.25.sp
        )
    )

    val shapes = Shapes(
        small = RoundedCornerShape(4.dp),
        medium = RoundedCornerShape(4.dp),
        large = RoundedCornerShape(0.dp)
    )

    MaterialTheme(
        colors = colors,
        typography = typography,
        shapes = shapes,
        content = content
    )
}
