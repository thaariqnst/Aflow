package com.thaariqnst.aflow.ui.createhabit

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.thaariqnst.aflow.data.LocaleString
import com.thaariqnst.aflow.ui.theme.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreateHabitScreen() {
    val scrollBarBehavior = TopAppBarDefaults.pinnedScrollBehavior()

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text(text = LocaleString.NEW_HABIT, style = Title3) },
                scrollBehavior = scrollBarBehavior,
                colors = TopAppBarDefaults.topAppBarColors(containerColor = backgroundLight)
            )
        }
    ) { contentPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(contentPadding)
                .background(backgroundLight)
        ) {

        }
    }
}