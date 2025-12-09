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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.thaariqnst.aflow.ui.onboarding.OnboardingUtil.getOnboardingImage
import com.thaariqnst.aflow.ui.onboarding.OnboardingUtil.getOnboardingSubtitle
import com.thaariqnst.aflow.ui.onboarding.OnboardingUtil.getOnboardingTitle
import com.thaariqnst.aflow.ui.theme.*

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
                style = Title1,
                color = onPrimaryContainerLight,
                text = getOnboardingTitle(page)
            )
            Text(
                textAlign = TextAlign.Center,
                style = Body,
                color = onPrimaryContainerLight,
                text = getOnboardingSubtitle(page)
            )
        }
    }
}