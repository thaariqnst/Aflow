package com.thaariqnst.aflow.ui.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.thaariqnst.aflow.R
import com.thaariqnst.aflow.ui.theme.primaryLight

@Composable
fun HabitIcon() {
    Box(
        modifier = Modifier
            .clip(CircleShape)
            .size(48.dp)
            .background(primaryLight.copy(alpha = 0.2f)),
        contentAlignment = Alignment.Center
    ) {
        Icon(
            painter = painterResource(R.drawable.ic_book),
            contentDescription = null,
            tint = Color.Unspecified,
        )
    }
}

@Composable
fun CheckButton(
    isChecked: Boolean,
    onClick: () -> Unit
) {
    IconButton(onClick = { onClick.invoke() }) {
        Icon(
            modifier = Modifier.size(48.dp),
            painter = painterResource(
                if (isChecked) R.drawable.btn_checked_filled_24
                else R.drawable.btn_checked_outlined_24
            ),
            contentDescription = null,
            tint = Color.Unspecified,
        )
    }
}