package com.gianlu.aria2app.ui.theme

import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.ui.graphics.Color

// Aria2App Core Expressive Palette
val AriaPrimaryLight = Color(0xFFBF360C)
val AriaOnPrimaryLight = Color(0xFFFFFFFF)
val AriaPrimaryContainerLight = Color(0xFFFFDBCF)
val AriaOnPrimaryContainerLight = Color(0xFF3B0900)

val AriaSecondaryLight = Color(0xFF77574E)
val AriaOnSecondaryLight = Color(0xFFFFFFFF)
val AriaSecondaryContainerLight = Color(0xFFFFDBCF)
val AriaOnSecondaryContainerLight = Color(0xFF2C160F)

val AriaTertiaryLight = Color(0xFF6C5D2F)
val AriaOnTertiaryLight = Color(0xFFFFFFFF)
val AriaTertiaryContainerLight = Color(0xFFF6E1A7)
val AriaOnTertiaryContainerLight = Color(0xFF231B00)

val AriaBackgroundLight = Color(0xFFFCFCFF)
val AriaOnBackgroundLight = Color(0xFF1A1C1E)
val AriaSurfaceLight = Color(0xFFFCFCFF)
val AriaOnSurfaceLight = Color(0xFF1A1C1E)
val AriaSurfaceVariantLight = Color(0xFFEDE0DC)
val AriaOnSurfaceVariantLight = Color(0xFF53433F)

// Dark Palette
val AriaPrimaryDark = Color(0xFFFFB59D)
val AriaOnPrimaryDark = Color(0xFF5F1600)
val AriaPrimaryContainerDark = Color(0xFF862500)
val AriaOnPrimaryContainerDark = Color(0xFFFFDBCF)

val AriaSecondaryDark = Color(0xFFE7BDB2)
val AriaOnSecondaryDark = Color(0xFF442A22)
val AriaSecondaryContainerDark = Color(0xFF5D4037)
val AriaOnSecondaryContainerDark = Color(0xFFFFDBCF)

val AriaTertiaryDark = Color(0xFFD9C58D)
val AriaOnTertiaryDark = Color(0xFF3B2F05)
val AriaTertiaryContainerDark = Color(0xFF53451A)
val AriaOnTertiaryContainerDark = Color(0xFFF6E1A7)

val AriaBackgroundDark = Color(0xFF1A1C1E)
val AriaOnBackgroundDark = Color(0xFFE2E2E6)
val AriaSurfaceDark = Color(0xFF121316)
val AriaOnSurfaceDark = Color(0xFFC6C6CA)
val AriaSurfaceVariantDark = Color(0xFF53433F)
val AriaOnSurfaceVariantDark = Color(0xFFD8C2BC)

// Semantic Action Colors for MD3E Speed Dial / Actions
val ActionSearchColor = Color(0xFF795548)
val ActionTorrentColor = Color(0xFF43A047)
val ActionMetalinkColor = Color(0xFF5E35B1)
val ActionUriColor = Color(0xFF546E7A)
val ActionBatchColor = Color(0xFFF57F17)
val ActionWebViewColor = Color(0xFF1E88E5)

val ExpressiveLightColorScheme = lightColorScheme(
    primary = AriaPrimaryLight,
    onPrimary = AriaOnPrimaryLight,
    primaryContainer = AriaPrimaryContainerLight,
    onPrimaryContainer = AriaOnPrimaryContainerLight,
    secondary = AriaSecondaryLight,
    onSecondary = AriaOnSecondaryLight,
    secondaryContainer = AriaSecondaryContainerLight,
    onSecondaryContainer = AriaOnSecondaryContainerLight,
    tertiary = AriaTertiaryLight,
    onTertiary = AriaOnTertiaryLight,
    tertiaryContainer = AriaTertiaryContainerLight,
    onTertiaryContainer = AriaOnTertiaryContainerLight,
    background = AriaBackgroundLight,
    onBackground = AriaOnBackgroundLight,
    surface = AriaSurfaceLight,
    onSurface = AriaOnSurfaceLight,
    surfaceVariant = AriaSurfaceVariantLight,
    onSurfaceVariant = AriaOnSurfaceVariantLight
)

val ExpressiveDarkColorScheme = darkColorScheme(
    primary = AriaPrimaryDark,
    onPrimary = AriaOnPrimaryDark,
    primaryContainer = AriaPrimaryContainerDark,
    onPrimaryContainer = AriaOnPrimaryContainerDark,
    secondary = AriaSecondaryDark,
    onSecondary = AriaOnSecondaryDark,
    secondaryContainer = AriaSecondaryContainerDark,
    onSecondaryContainer = AriaOnSecondaryContainerDark,
    tertiary = AriaTertiaryDark,
    onTertiary = AriaOnTertiaryDark,
    tertiaryContainer = AriaTertiaryContainerDark,
    onTertiaryContainer = AriaOnTertiaryContainerDark,
    background = AriaBackgroundDark,
    onBackground = AriaOnBackgroundDark,
    surface = AriaSurfaceDark,
    onSurface = AriaOnSurfaceDark,
    surfaceVariant = AriaSurfaceVariantDark,
    onSurfaceVariant = AriaOnSurfaceVariantDark
)
