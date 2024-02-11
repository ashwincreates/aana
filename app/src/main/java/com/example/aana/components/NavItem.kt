package com.example.aana.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector

@Composable
fun NavItem(icon: ImageVector, label: String, onClick: () -> Unit, isSelected: Boolean = false) {
    FilledTonalButton(
        onClick = onClick,
        colors =
            if (!isSelected) ButtonDefaults.filledTonalButtonColors(containerColor = Color.Transparent)
            else ButtonDefaults.filledTonalButtonColors()
    ) {
        Icon(imageVector = icon, label)
    }
}