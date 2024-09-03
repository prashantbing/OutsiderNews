package com.multiplatformdemo.prashant.home

import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ReadOnlyComposable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.multiplatformdemo.prashant.home.FontSize.large
import com.multiplatformdemo.prashant.home.FontSize.small
import com.multiplatformdemo.prashant.home.FontSize.tripleXL
import kmpdemo.composeapp.generated.resources.Res
import kmpdemo.composeapp.generated.resources.lato_black
import kmpdemo.composeapp.generated.resources.lato_bold
import kmpdemo.composeapp.generated.resources.lato_light
import kmpdemo.composeapp.generated.resources.lato_regular
import kmpdemo.composeapp.generated.resources.lato_thin
import org.jetbrains.compose.resources.Font

@Composable
fun LatoFontFamily() = FontFamily(
    Font(Res.font.lato_black, weight = FontWeight.Black),
    Font(Res.font.lato_bold, weight = FontWeight.Bold),
    Font(Res.font.lato_light, weight = FontWeight.Light)   ,
    Font(Res.font.lato_regular, weight = FontWeight.Normal)              ,
    Font(Res.font.lato_thin, weight = FontWeight.Thin)                     ,
)

@Composable
fun LatoTypography() = Typography().run {

    val fontFamily = LatoFontFamily()
    copy(
        displayLarge = displayLarge.copy(fontFamily = fontFamily),
        displayMedium = displayMedium.copy(fontFamily = fontFamily),
        displaySmall = displaySmall.copy(fontFamily = fontFamily),
        headlineLarge = headlineLarge.copy(fontFamily = fontFamily),
        headlineMedium = headlineMedium.copy(fontFamily = fontFamily),
        headlineSmall = headlineSmall.copy(fontFamily = fontFamily),
        titleLarge = titleLarge.copy(fontFamily = fontFamily),
        titleMedium = titleMedium.copy(fontFamily = fontFamily),
        titleSmall = titleSmall.copy(fontFamily = fontFamily),
        bodyLarge = bodyLarge.copy(fontFamily =  fontFamily),
        bodyMedium = bodyMedium.copy(fontFamily = fontFamily),
        bodySmall = bodySmall.copy(fontFamily = fontFamily),
        labelLarge = labelLarge.copy(fontFamily = fontFamily),
        labelMedium = labelMedium.copy(fontFamily = fontFamily),
        labelSmall = labelSmall.copy(fontFamily = fontFamily)
    )
}

object FontSize{
    val normal =16.sp
    val large =18.sp
    val XL =20.sp
    val doubleXL =22.sp
    val tripleXL =24.sp
    val small =14.sp
}
val textInput: TextStyle
    @Composable
    get() = TextStyle(
        fontFamily = LatoFontFamily(),
        fontWeight = FontWeight.Normal,
    )

val textSource @Composable
get() = textInput.copy(fontSize = small, fontWeight = FontWeight.ExtraBold)

val textTitle @Composable
get() = textInput.copy(fontSize = large, fontWeight = FontWeight.ExtraBold)


val textDescription @Composable
get() = textInput.copy(fontSize = small, fontWeight = FontWeight.Normal)

val textTopBar @Composable
get() = textInput.copy(fontSize = tripleXL, fontWeight = FontWeight.Bold, letterSpacing = 6.sp)