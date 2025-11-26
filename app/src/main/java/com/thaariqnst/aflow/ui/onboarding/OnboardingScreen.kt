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
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.thaariqnst.aflow.data.LocaleString
import com.thaariqnst.aflow.ui.theme.*
import kotlinx.coroutines.launch

@Composable
fun OnboardingScreen(
    modifier: Modifier,
    isLoggedIn: Boolean,
    onSkipClicked: () -> Unit,
) {
    var onBoardingPage: Int by remember { mutableIntStateOf(0) }
    val onboardingPagerState = rememberPagerState(
        initialPage = 3,
        pageCount = { 4 }
    )
    val coroutineScope = rememberCoroutineScope()


    Scaffold {
        Column(
            modifier = Modifier
                .padding(it)
                .fillMaxSize()
                .background(color = bgWhite),
        ) {
            HorizontalPager(
                state = onboardingPagerState,
            ) { page ->
                OnboardingPage(
                    modifier = Modifier.weight(1f),
                    page = page
                )
            }

            Row(
                Modifier
                    .wrapContentHeight()
                    .fillMaxWidth()
                    .weight(1f),
                horizontalArrangement = Arrangement.Center
            ) {
                if (onboardingPagerState.currentPage != 0){
                    repeat(onboardingPagerState.pageCount) { iteration ->
                        val color = if (onboardingPagerState.currentPage == iteration) colorAccent else Color.LightGray
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
                            colors = ButtonColors(colorAccent, black, colorAccent, black),
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
                            colors = ButtonColors(colorAccent, black, colorAccent, black),
                            shape = RoundedCornerShape(99.dp),
                            onClick = {
                                coroutineScope.launch {
                                    if (onboardingPagerState.currentPage <= 4) onboardingPagerState.animateScrollToPage(onboardingPagerState.currentPage + 1)
                                }
                            }
                        ) {
                            Text(
                                modifier = Modifier.fillMaxWidth(),
                                textAlign = TextAlign.Center,
                                style = Title4,
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
                                text = LocaleString.SKIP
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun OnboardingBtn(page: Int) {

}

@Preview(showSystemUi = true)
@Composable
fun DefaultPreview() {
    OnboardingScreen(
        modifier = Modifier,
        isLoggedIn = false
    ) { }
}