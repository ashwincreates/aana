package com.example.aana.pages

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
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
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navigation
import com.example.aana.R

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Home() {
    val controller = rememberNavController()
    Scaffold(
        topBar = { TopAppBar(title = {Text(text = stringResource(R.string.app_name))}) },
        bottomBar = { BottomAppBar {
            Row (horizontalArrangement = Arrangement.SpaceAround, modifier = Modifier.fillMaxWidth()) {
                FilledTonalButton(onClick = { /*TODO*/ }) {
                    Icon(imageVector = Icons.Rounded.Home, "Dashboard")
                }
                FilledTonalButton(onClick = { /*TODO*/ }) {
                    Icon(imageVector = Icons.Rounded.AccountCircle, "Analytics")
                }
                FilledTonalButton(onClick = { /*TODO*/ }) {
                    Icon(imageVector = Icons.Rounded.Favorite, "Budgets")
                }
                FilledTonalButton(onClick = { /*TODO*/ }, colors = ButtonDefaults.filledTonalButtonColors(containerColor = Color.Transparent)) {
                    Icon(imageVector = Icons.Rounded.Favorite, "Category")
                }
            }
        }}
    ) {
         NavHost(navController = controller, startDestination =  "dashboard") {
             composable("dashboard") { Dashboard() }
             composable("analytics") { Analytics() }
             composable("budgets") { Budgets() }
             composable("category") { Category() }
        }
    }
}