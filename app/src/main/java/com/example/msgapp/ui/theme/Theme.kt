package com.example.msgapp.ui.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
// Esquema de cores escuras
private val DarkColorScheme = darkColorScheme(
    primary = GoldDark,
    secondary = LightGray,
    tertiary = Black,
    background = DarkGray,
    surface = Black,
    onPrimary = Black,
    onSecondary = GoldLight,
    onTertiary = GoldLight,
    onBackground = GoldLight,
    onSurface = GoldLight
)

// Esquema de cores claras
private val LightColorScheme = lightColorScheme(
    primary = GoldLight,
    secondary = DarkGray,
    tertiary = Black,
    background = Color(0xFFFFFBFE),
    surface = Color(0xFFFFFBFE),
    onPrimary = Black,
    onSecondary = GoldDark,
    onTertiary = GoldDark,
    onBackground = Black,
    onSurface = Black
)

@Composable
fun MsgAppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color é para Android 12+ (opcional, pode desativar)
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit,
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}
