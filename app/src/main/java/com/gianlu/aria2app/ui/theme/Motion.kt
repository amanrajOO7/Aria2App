package com.gianlu.aria2app.ui.theme

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.SpringSpec
import androidx.compose.animation.core.spring

object ExpressiveMotion {
    // Spatial spring: Used for positional and shape translation
    fun <T> spatialSpring(): SpringSpec<T> = spring(
        dampingRatio = Spring.DampingRatioMediumBouncy,
        stiffness = Spring.StiffnessLow
    )

    // Snappy spring: Used for icon transitions and quick state switches
    fun <T> snappySpring(): SpringSpec<T> = spring(
        dampingRatio = Spring.DampingRatioNoBouncy,
        stiffness = Spring.StiffnessMedium
    )

    // Bouncy spring: Emphasized spring for expressive actions and FAB expansion
    fun <T> bouncySpring(): SpringSpec<T> = spring(
        dampingRatio = 0.65f,
        stiffness = 300f
    )

    val SpatialSpring: SpringSpec<Float> = spatialSpring()
    val SnappySpring: SpringSpec<Float> = snappySpring()
    val BouncySpring: SpringSpec<Float> = bouncySpring()
}
