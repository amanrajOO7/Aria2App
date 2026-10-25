package com.gianlu.aria2app.ui.theme

import androidx.compose.animation.core.AnimationSpec
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring

object ExpressiveMotion {
    // Spatial spring: Used for positional and shape translation
    val SpatialSpring: AnimationSpec<Float> = spring(
        dampingRatio = Spring.DampingRatioMediumBouncy,
        stiffness = Spring.StiffnessLow
    )

    // Snappy spring: Used for icon transitions and quick state switches
    val SnappySpring: AnimationSpec<Float> = spring(
        dampingRatio = Spring.DampingRatioNoBouncy,
        stiffness = Spring.StiffnessMedium
    )

    // Bouncy spring: Emphasized spring for expressive actions and FAB expansion
    val BouncySpring: AnimationSpec<Float> = spring(
        dampingRatio = 0.65f,
        stiffness = 300f
    )
}
