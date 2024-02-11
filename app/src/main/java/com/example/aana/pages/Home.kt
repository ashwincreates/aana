package com.example.aana.pages

import android.annotation.SuppressLint
import android.util.Log
import android.widget.ScrollView
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material.icons.rounded.Favorite
import androidx.compose.material.icons.rounded.Home
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import com.example.aana.R
import com.example.aana.components.NavItem

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Home() {
    val controller = rememberNavController()

    fun onNavigate(route: String) {
        Log.d("navigation",controller.currentBackStackEntry?.destination?.hierarchy.toString())
        controller.navigate(route)
    }

    fun isCurrentRoute(controller: NavHostController, currentRoute: String): Boolean {
        Log.d("nav",controller.currentBackStackEntry.toString())
        return controller.currentDestination?.route == currentRoute
    }
    Scaffold(
        topBar = { TopAppBar(title = {Text(text = stringResource(R.string.app_name))}) },
        bottomBar = { BottomAppBar {
            Row (horizontalArrangement = Arrangement.SpaceAround, modifier = Modifier.fillMaxWidth()) {
                arrayOf("dashboard", "analytics", "budgets", "category").map {
                    route ->
                    NavItem(icon = Icons.Rounded.Home, label = route, onClick = { onNavigate(route) }, isSelected = isCurrentRoute(controller, route))
                }
            }
        }}
    ) {
        innerPadding -> Column (modifier = Modifier
        .padding(innerPadding)
        .padding(16.dp)) {
        NavHost(navController = controller, startDestination =  "dashboard") {
            composable("dashboard") { Dashboard() }
            composable("analytics") { Analytics() }
            composable("budgets") { Budgets() }
            composable("category") { Category() }
        }

    }
    }
}

fun isCurrentRoute(controller: NavHostController, currentRoute: String): Boolean {
    return controller.currentDestination?.route == currentRoute
}