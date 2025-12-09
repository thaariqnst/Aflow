package com.thaariqnst.aflow.ui.onboarding

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.thaariqnst.aflow.data.LocaleString
import com.thaariqnst.aflow.ui.theme.*
import kotlinx.coroutines.launch

@Composable
fun OnboardingScreen(
    onSkipClicked: () -> Unit,
) {
    val coroutineScope = rememberCoroutineScope()
    val onboardingPagerState = rememberPagerState(
        initialPage = 0,
        pageCount = { 4 }
    )

    Scaffold {
        Column(
            modifier = Modifier
                .padding(it)
                .fillMaxSize()
                .background(color = surfaceLight),
        ) {
            HorizontalPager(
                state = onboardingPagerState,
            ) { page ->
                OnboardingPage(
                    modifier = Modifier.weight(1f),
                    page = page
                )
            }

            Column {
                Row(
                    Modifier
                        .wrapContentHeight()
                        .fillMaxWidth()
                        .weight(1f),
                    horizontalArrangement = Arrangement.Center
                ) {
                    if (onboardingPagerState.currentPage != 0){
                        repeat(onboardingPagerState.pageCount) { iteration ->
                            val color = if (onboardingPagerState.currentPage == iteration) primaryContainerLight else Color.LightGray
                            Box(
                                modifier = Modifier
                                    .padding(2.dp)
                                    .clip(CircleShape)
                                    .background(color)
                                    .size(8.dp)
                            )
                        }
                    }
                }

                when (onboardingPagerState.currentPage) {
                    0 -> {
                        Column(
                            modifier = Modifier.padding(horizontal = 16.dp).padding(bottom = 32.dp),
                            verticalArrangement = Arrangement.Bottom
                        ) {
                            Button(
                                modifier = Modifier.fillMaxWidth().height(48.dp),
                                colors = ButtonColors(primaryContainerLight, black, primaryContainerLight, black),
                                shape = RoundedCornerShape(99.dp),
                                onClick = {
                                    coroutineScope.launch {
                                        onboardingPagerState.animateScrollToPage(1)
                                    }
                                }
                            ) {
                                Text(
                                    modifier = Modifier.fillMaxWidth(),
                                    textAlign = TextAlign.Center,
                                    style = Title4,
                                    fontWeight = FontWeight.Bold,
                                    color = onPrimaryContainerLight,
                                    text = LocaleString.GET_STARTED
                                )
                            }
                        }
                    }

                    else -> {
                        Column(
                            modifier = Modifier.padding(horizontal = 16.dp).padding(bottom = 32.dp),
                            verticalArrangement = Arrangement.Bottom
                        ) {
                            Button(
                                modifier = Modifier.fillMaxWidth().padding(bottom = 12.dp).height(48.dp),
                                colors = ButtonColors(primaryContainerLight, black, primaryContainerLight, black),
                                shape = RoundedCornerShape(99.dp),
                                onClick = {
                                    if (onboardingPagerState.currentPage == onboardingPagerState.pageCount - 1) onSkipClicked.invoke()
                                    else coroutineScope.launch {
                                        if (onboardingPagerState.currentPage <= 4) onboardingPagerState.animateScrollToPage(onboardingPagerState.currentPage + 1)
                                    }
                                }
                            ) {
                                Text(
                                    modifier = Modifier.fillMaxWidth(),
                                    textAlign = TextAlign.Center,
                                    style = Title4,
                                    fontWeight = FontWeight.Bold,
                                    color = onPrimaryContainerLight,
                                    text = LocaleString.CONTINUE
                                )
                            }

                            Button(
                                modifier = Modifier.fillMaxWidth().height(48.dp),
                                colors = ButtonColors(Color.Transparent, black, Color.Transparent, black),
                                onClick = onSkipClicked
                            ) {
                                Text(
                                    textAlign = TextAlign.Center,
                                    style = Title4,
                                    fontWeight = FontWeight.Bold,
                                    color = onPrimaryContainerLight,
                                    text = LocaleString.SKIP
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun DefaultPreview() {
    OnboardingScreen { }
}