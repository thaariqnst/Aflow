package com.thaariqnst.aflow.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.thaariqnst.aflow.data.LocaleString
import com.thaariqnst.aflow.ui.theme.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    navController: NavController,
    onFabClicked: () -> Unit,
) {
    val scrollBarBehavior = TopAppBarDefaults.pinnedScrollBehavior()

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .nestedScroll(scrollBarBehavior.nestedScrollConnection)
            .background(surfaceContainerLowLight),
        floatingActionButton = {
            FloatingActionButton(
                containerColor = primaryLight,
                onClick = { onFabClicked.invoke() }
            ) {
                Icon(
                    modifier = Modifier.size(32.dp),
                    imageVector = Icons.Default.Add,
                    contentDescription = "Create New Habit",
                    tint = onPrimaryLight,
                )
            }
        },
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = LocaleString.YOUR_HABITS,
                        style = Title3
                    )
                },
                actions = {
                    IconButton(onClick = { navController.navigate("Onboarding") }) {
                        Icon(
                            imageVector = Icons.Default.DateRange,
                            contentDescription = "Open Calendar"
                        )
                    }
                },
                scrollBehavior = scrollBarBehavior
            )
        }
    ) { contentPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(contentPadding)
                .padding(horizontal = 16.dp)
        ) {
            items(4) {
                HabitCard(it) {  }
            }
        }
    }
}