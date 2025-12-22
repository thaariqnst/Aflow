package com.thaariqnst.aflow.ui.createhabit

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.thaariqnst.aflow.ui.theme.*

@Composable
fun NewHabitSection(
    title: String,
    content: @Composable () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Text(
            text = title,
            style = Title3
        )

        content()
    }
}

@Composable
fun NewHabitTextField(
    textFieldTitle: String,
    value: String,
    placeholder: String,
    singleLine: Boolean = false,
    minLines: Int = 1,
    maxChar: Int,
    onValueChange: (String) -> Unit
) {
    Column(
       modifier = Modifier.padding(top = 16.dp)
    ) {
        Text(
            text = textFieldTitle,
            style = Title4,
            color = outlineLight
        )
        OutlinedTextField(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp)
                .background(onPrimaryLight),
            value = value,
            onValueChange = { if (it.length <= maxChar) onValueChange(it) },
            placeholder = { Text(text = placeholder, style = Body, color = outlineLight) },
            singleLine = singleLine,
            minLines = minLines,
            colors = TextFieldDefaults.colors(
                focusedContainerColor = Color.White,
                unfocusedContainerColor = Color.White,
                focusedIndicatorColor = textFieldOutline,
                unfocusedIndicatorColor = textFieldOutline),
            shape = RoundedCornerShape(24.dp)
        )
    }
}