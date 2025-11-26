package com.thaariqnst.aflow.ui.onboarding

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.thaariqnst.aflow.R
import com.thaariqnst.aflow.data.LocaleString
import com.thaariqnst.aflow.ui.theme.Body
import com.thaariqnst.aflow.ui.theme.Title1

@Composable
fun OnboardingPage(modifier: Modifier, page: Int) {
    Column(
        modifier = modifier,
    ) {
        Image(
            modifier = Modifier.fillMaxWidth().padding(bottom = 20.dp),
            painter = painterResource(getOnboardingImage(page)),
            contentDescription = "on_boarding_1",
            contentScale = ContentScale.FillWidth
        )

        Column(
            modifier = Modifier.padding(horizontal = 16.dp)
        ) {
            Text(
                modifier = Modifier.fillMaxWidth().padding(bottom = 12.dp),
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                style = Title1,
                text = getOnboardingTitle(page)
            )
            Text(
                textAlign = TextAlign.Center,
                style = Body,
                text = getOnboardingSubtitle(page)
            )
        }
    }
}

fun getOnboardingImage(page: Int): Int {
    return when (page) {
        0 -> R.drawable.on_boarding_1
        1 -> R.drawable.on_boarding_1
        2 -> R.drawable.on_boarding_1
        3 -> R.drawable.on_boarding_1
        else -> R.drawable.on_boarding_1
    }
}

fun getOnboardingTitle(page: Int): String {
    return when (page) {
        0 -> LocaleString.WELCOME_T0_AFLOW
        1 -> LocaleString.BUILD_LASTING_HABITS
        2 -> LocaleString.STAY_CONSISTENT_EVERY_DAY
        3 -> LocaleString.REACH_YOUR_GOALS_WITH_CLARITY
        else -> LocaleString.WELCOME_T0_AFLOW
    }
}

fun getOnboardingSubtitle(page: Int): String {
    return when (page) {
        0 -> LocaleString.AFLOW_HELPS_YOU_TRACK_YOUR_GOALS
        1 -> LocaleString.TRACK_YOUR_HABITS_STAY_FOCUSED_AND_ACHIEVE_YOUR_GOALS_WITH_EASE
        2 -> LocaleString.SMALL_STEPS_LEAD_TO_BIG_PROGRESS
        3 -> LocaleString.STAY_ON_TRACK_AND_GROW
        else -> LocaleString.AFLOW_HELPS_YOU_TRACK_YOUR_GOALS
    }
}