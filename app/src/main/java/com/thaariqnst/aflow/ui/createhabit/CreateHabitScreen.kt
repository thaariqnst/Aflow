package com.thaariqnst.aflow.ui.createhabit

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.thaariqnst.aflow.data.LocaleString
import com.thaariqnst.aflow.ui.theme.*

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CreateHabitScreen(
    onBackClicked: () -> Unit
) {
    val scrollBarBehavior = TopAppBarDefaults.pinnedScrollBehavior()

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text(text = LocaleString.NEW_HABIT, style = Title3) },
                scrollBehavior = scrollBarBehavior,
                colors = TopAppBarDefaults.topAppBarColors(containerColor = backgroundLight),
                navigationIcon = {
                    IconButton(onClick = { onBackClicked.invoke() }) {
                        Icon(
                            imageVector = Icons.AutoMirrored.Default.ArrowBack,
                            contentDescription = "Back"
                        )
                    }
                }
            )
        }
    ) { contentPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(contentPadding)
                .padding(horizontal = 16.dp)
                .background(backgroundLight)
        ) {
            NewHabitSection(LocaleString.HABIT) {
                var habitName by remember { mutableStateOf("") }
                var habitDescription by remember { mutableStateOf("") }

                NewHabitTextField(
                    LocaleString.NAME,
                    habitName,
                    LocaleString.EG_DRINK_WATER,
                    singleLine = true,
                    maxChar = 32
                    ) { habitName = it }

                NewHabitTextField(
                    LocaleString.DESCRIPTION_OPTIONAL,
                    habitDescription,
                    LocaleString.EG_GLASSES_A_DAY,
                    singleLine = false,
                    minLines = 3,
                    maxChar = 100
                ) { habitDescription = it }

            }
        }
    }
}