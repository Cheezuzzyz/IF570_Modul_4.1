import androidx.compose.ui.test.junit4.createComposeRule
import com.example.compose.rally.ui.components.RallyTopAppBar
import org.junit.Rule
import org.junit.Test
import androidx.compose.ui.test.assertIsSelected
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.onRoot
import androidx.compose.ui.test.printToLog

class RallyScreen {
    companion object {
        val Accounts: com.example.compose.rally.RallyScreen
            get() {
                TODO()
            }
    }

}

class TopAppBarTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun rallyTopAppBarTest_currentTabSelected() {
        val allScreens = RallyScreen.values().toList()
        composeTestRule.setContent {
            RallyTopAppBar(
                allScreens = allScreens,
                onTabSelected = { },
                currentScreen = RallyScreen.Accounts
            )
        }

        composeTestRule
            .onNodeWithContentDescription(RallyScreen.Accounts.name)
            .assertIsSelected()
    }
}

fun rallyTopAppBarTest_currentLabelExists() {
    val allScreens = RallyScreen.values().toList()
    val composeTestRule = null
    composeTestRule.setContent {
        RallyTopAppBar(
            allScreens = allScreens,
            onTabSelected = { },
            currentScreen = RallyScreen.Accounts
        )
    }

    composeTestRule
        .onNodeWithContentDescription(RallyScreen.Accounts.name)
        .assertExists()
}