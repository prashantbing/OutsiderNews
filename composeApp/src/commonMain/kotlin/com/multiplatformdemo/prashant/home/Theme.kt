package com.multiplatformdemo.prashant.home

import androidx.compose.material.Colors
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.multiplatformdemo.prashant.home.FontSize.large
import com.multiplatformdemo.prashant.home.FontSize.small

object FontSize{
    val normal =16.sp
    val large =18.sp
    val XL =20.sp
    val doubleXL =22.sp
    val tripleXL =24.sp
    val small =14.sp
}

val textSource = TextStyle(fontSize = small, fontWeight = FontWeight.ExtraBold)
val textTitle = TextStyle(fontSize = large, fontWeight = FontWeight.ExtraBold)
val textDescription = TextStyle(fontSize = small, fontWeight = FontWeight.Normal)