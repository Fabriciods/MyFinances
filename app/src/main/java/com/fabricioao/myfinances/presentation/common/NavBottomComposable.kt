package com.fabricioao.myfinances.presentation.common

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Home
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector

@Composable
fun NavBottomComposable() {
}

sealed class BottomNavItem(val routes: String, val icon: ImageVector, val label: String) {
    object Home : BottomNavItem("home", Icons.Default.Home, "Home")
    object Add : BottomNavItem("add",Icons.Default.Add, "Add")
}