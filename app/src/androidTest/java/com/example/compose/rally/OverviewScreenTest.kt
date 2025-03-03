package com.example.compose.rally

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithText
import com.example.compose.rally.ui.overview.OverviewBody
import org.junit.Rule
import org.junit.Test
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.VectorConverter
import androidx.compose.animation.core.animateValue
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.ui.unit.Dp

class OverviewScreenTest {

    @get:Rule
    val composeTestRule = createComposeRule()


    @Test
    fun overviewScreen_alertsDisplayed() {
        composeTestRule.setContent {
            OverviewBody()
        }

        composeTestRule
            .onNodeWithText("Alerts")
            .assertIsDisplayed()
    }
}

val infiniteElevationAnimation = rememberInfiniteTransition()
val animatedElevation: Dp by infiniteElevationAnimation.animateValue(
    initialValue = 1.dp,
    targetValue = 8.dp,
    typeConverter = Dp.VectorConverter,
    animationSpec = infiniteRepeatable(
        animation = tween(500),
        repeatMode = RepeatMode.Reverse
    )
)
Card(elevation = animatedElevation) {