package com.example.assignment1.ui.theme

import android.app.Activity
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

// General Color schemes

private val DarkColorScheme = darkColorScheme(
    primary = Purple80,
    secondary = PurpleGrey80,
    tertiary = Pink80,
    background = Color(0xFF2C2A28),
    surface = Color(0xFF383532)
)

private val LightColorScheme = lightColorScheme(
    primary = Purple40,
    secondary = PurpleGrey40,
    tertiary = Pink40,
    background = RusticBeige,
    surface = RusticBeige,
    onBackground = Color.Black,
    onSurface = Color.Black
)

// Category-specific light color schemes

private val CuteLightColorScheme = lightColorScheme(
    primary = CutePrimary,
    secondary = Pink40,
    tertiary = Pink80,
    background = CutePink,
    surface = CuteSurface,
    onSurface = Color.Black
)

private val CoolLightColorScheme = lightColorScheme(
    primary = CoolPrimary,
    secondary = PurpleGrey40,
    tertiary = Purple80,
    background = CoolSpaceGrey,
    surface = Color(0xFFA1A4B9),
    onSurface = Color.Black
)

private val ClassicLightColorScheme = lightColorScheme(
    primary = ClassicPrimary,
    secondary = PurpleGrey40,
    tertiary = Pink40,
    background = ClassicCream,
    surface = ClassicCream,
    onSurface = Color.Black
)

// Composable function to determine the ColorScheme based on the category
@Composable
fun getCategoryColorScheme(category: String?, darkTheme: Boolean = isSystemInDarkTheme()): ColorScheme {
    val targetCategory = category?.lowercase()

    return if (darkTheme) {
        when (targetCategory) {
            else -> DarkColorScheme
        }
    } else {
        when (targetCategory) {
            "cute" -> CuteLightColorScheme
            "cool" -> CoolLightColorScheme
            "sad" -> ClassicLightColorScheme
            else -> LightColorScheme
        }
    }
}

// Main Assignment1Theme composable function
@Composable
fun Assignment1Theme(
    colorScheme: ColorScheme = getCategoryColorScheme(category = null),
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}