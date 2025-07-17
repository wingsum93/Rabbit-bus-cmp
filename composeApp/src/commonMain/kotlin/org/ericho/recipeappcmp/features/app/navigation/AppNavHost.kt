package org.ericho.recipeappcmp.features.app.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import org.ericho.recipeappcmp.features.app.data.AppState
import org.ericho.recipeappcmp.features.app.data.Screen
import org.ericho.recipeappcmp.features.detail.navigation.detailNavGraph
import org.ericho.recipeappcmp.features.search.navigation.searchNavGraph
import org.ericho.recipeappcmp.features.tabs.navigation.tabsNavGraph

@Composable
fun AppNavHost(
    modifier: Modifier = Modifier,
    appState: AppState,
    startDestination: String = Screen.Tabs.route,
    isUserLoggedIn: () -> Boolean,
    openLoginBottomSheet: (() -> Unit) -> Unit,
    onLogout: () -> Unit
) {

    val navController = appState.navController

    val tabNavController = rememberNavController()

    NavHost(navController, startDestination = startDestination) {

        tabsNavGraph(
            tabNavController = tabNavController,
            navigateToDetail = {
                appState.navigateToDetail(it)
            },
            isUserLoggedIn = isUserLoggedIn,
            openLoginBottomSheet = openLoginBottomSheet,
            onLogout = onLogout,
            navigateToSearch = appState::navigateToSearch
        )

        searchNavGraph(
            navigateToDetail = {
                appState.navigateToDetail(it)
            },
            onBackPress = appState::navigateBack
        )

        detailNavGraph(
            onBackClick = appState::navigateBack,
            isUserLoggedIn = isUserLoggedIn,
            openLoginBottomSheet = openLoginBottomSheet,
        )
    }


}