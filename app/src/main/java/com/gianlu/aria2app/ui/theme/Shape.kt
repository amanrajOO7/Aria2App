package com.gianlu.aria2app.ui.theme

import androidx.compose.foundation.shape.CornerBasedShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Shapes
import androidx.compose.ui.unit.dp

// Material Design 3 Expressive Shapes
val ExpressiveShapes = Shapes(
    extraSmall = RoundedCornerShape(8.dp),
    small = RoundedCornerShape(12.dp),
    medium = RoundedCornerShape(16.dp),
    large = RoundedCornerShape(24.dp),
    extraLarge = RoundedCornerShape(32.dp)
)

// Custom Expressive tokens for morphing FAB & Action Pills
val ExpressivePillShape: CornerBasedShape = RoundedCornerShape(50)
val ExpressiveSquircleShape: CornerBasedShape = RoundedCornerShape(20.dp)
