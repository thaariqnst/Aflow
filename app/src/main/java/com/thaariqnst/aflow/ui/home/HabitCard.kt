package com.thaariqnst.aflow.ui.home

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.unit.dp
import com.thaariqnst.aflow.ui.theme.*

@Composable
fun HabitCard(
    index: Int,
    onClicked: () -> Unit,
) {
    var isChecked by remember { mutableStateOf(false) }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
            .padding(bottom = 12.dp)
            .alpha(if (isChecked) 0.7f else 1f),
        colors = CardDefaults.cardColors(
            containerColor = secondaryContainerLight.copy(alpha = 0.5f)
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 0.dp),
        onClick = {
            onClicked.invoke()
        }
    ) {
        Row(
            modifier = Modifier.padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            HabitIcon()

            Column(
                modifier = Modifier.weight(1f).padding(start = 16.dp),
                horizontalAlignment = Alignment.Start
            ) {
                // max char: 30
                Text(
                    text = "Item Title",
                    style = Title4,
                    maxLines = 1,
                )
                Text(
                    text = "Streak: $index days",
                    style = Body2
                )
            }

            CheckButton(isChecked) { isChecked = !isChecked }
        }
    }
}