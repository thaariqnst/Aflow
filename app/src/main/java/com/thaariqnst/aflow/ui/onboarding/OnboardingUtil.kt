package com.thaariqnst.aflow.ui.onboarding

import com.thaariqnst.aflow.R
import com.thaariqnst.aflow.data.LocaleString

object OnboardingUtil {
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
}