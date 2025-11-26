package com.thaariqnst.aflow.ui.theme

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.thaariqnst.aflow.R

val manropeFamily = FontFamily(
    Font(R.font.manrope_extralight, FontWeight.ExtraLight),
    Font(R.font.manrope_light, FontWeight.Light),
    Font(R.font.manrope, FontWeight.Normal),
    Font(R.font.manrope_medium, FontWeight.Medium),
    Font(R.font.manrope_semibold, FontWeight.SemiBold),
    Font(R.font.manrope_bold, FontWeight.Bold),
    Font(R.font.manrope_extrabold, FontWeight.ExtraBold),
)

val Title1 = TextStyle(
    fontSize = 28.sp,
    lineHeight = 32.sp,
    fontFamily = manropeFamily,
    fontWeight = FontWeight.Bold,
    letterSpacing = 0.15.sp,
)

val Title2 = TextStyle(
    fontSize = 24.sp,
    lineHeight = 28.sp,
    fontFamily = manropeFamily,
    fontWeight = FontWeight.Bold,
    letterSpacing = 0.15.sp,
)

val Title3 = TextStyle(
    fontSize = 20.sp,
    lineHeight = 24.sp,
    fontFamily = manropeFamily,
    fontWeight = FontWeight.Bold,
    letterSpacing = 0.15.sp,
)

val Title4 = TextStyle(
    fontSize = 16.sp,
    lineHeight = 20.sp,
    fontFamily = manropeFamily,
    fontWeight = FontWeight.SemiBold,
    letterSpacing = 0.15.sp,
)

val Title5 = TextStyle(
    fontSize = 14.sp,
    lineHeight = 16.sp,
    fontFamily = manropeFamily,
    fontWeight = FontWeight.SemiBold,
    letterSpacing = 0.15.sp,
)

val Title6 = TextStyle(
    fontSize = 12.sp,
    lineHeight = 16.sp,
    fontFamily = manropeFamily,
    fontWeight = FontWeight.SemiBold,
    letterSpacing = 0.3.sp
)

val TextCaption = TextStyle(
    fontSize = 12.sp,
    lineHeight = 16.sp,
    fontFamily = manropeFamily,
    fontWeight = FontWeight.Normal,
    letterSpacing = 0.4.sp
)

val Body = TextStyle(
    fontSize = 16.sp,
    lineHeight = 24.sp,
    fontFamily = manropeFamily,
    fontWeight = FontWeight.Normal,
    letterSpacing = 0.25.sp,
)

val Body2 = TextStyle(
    fontSize = 14.sp,
    lineHeight = 24.sp,
    fontFamily = manropeFamily,
    fontWeight = FontWeight.Normal,
    letterSpacing = 0.25.sp,
)

val Caption = TextStyle(
    fontSize = 12.sp,
    lineHeight = 16.sp,
    fontFamily = manropeFamily,
    fontWeight = FontWeight.Normal,
    letterSpacing = 0.4.sp,
)

val CaptionLongForm = TextStyle(
    fontSize = 12.sp,
    lineHeight = 20.sp,
    fontFamily = manropeFamily,
    fontWeight = FontWeight.Normal,
    letterSpacing = 0.4.sp,
)