package com.thaariqnst.aflow

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.thaariqnst.aflow.ui.bottomnav.BottomNavBar
import com.thaariqnst.aflow.ui.createhabit.CreateHabitScreen
import com.thaariqnst.aflow.ui.home.HomeScreen
import com.thaariqnst.aflow.ui.onboarding.OnboardingScreen
import com.thaariqnst.aflow.ui.theme.AflowTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AflowTheme {
                val navController = rememberNavController()
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentRoute = navBackStackEntry?.destination?.route
                val bottomBarRoutes = listOf("Home", "Analytics", "Settings")

                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    bottomBar = {
                        if (currentRoute in bottomBarRoutes) {
                            BottomNavBar(
                                currentRoute = currentRoute,
                                onItemSelected ={ route ->
                                    navController.navigate(route) {
                                        popUpTo("Home") { inclusive = false }
                                        launchSingleTop = true
                                    }
                                }
                            )
                        }
                    }
                )
                { innerPadding ->
                    NavHost(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding)
                            .consumeWindowInsets(innerPadding),
                        navController = navController,
                        startDestination = "CreateNewHabit" //"Onboarding"
                    ) {
                        composable("Onboarding") {
                            OnboardingScreen {
                                navController.navigate("Home") {
                                    popUpTo("Onboarding") { inclusive = true }
                                }
                            }
                        }

                        composable("Home") { HomeScreen(
                            onHabitCardClicked = { navController.navigate("HabitDetails") },
                            onFabClicked = { navController.navigate("CreateNewHabit") },
                            onCalendarClicked = { navController.navigate("Onboarding") }
                        ) }
                        composable("Analytics") {  }
                        composable("Settings") {  }

                        composable("CreateNewHabit") { CreateHabitScreen(
                            onBackClicked = { navController.popBackStack() }
                        ) }
                        composable("HabitDetails") {  }
                    }
                }
            }
        }
    }
}