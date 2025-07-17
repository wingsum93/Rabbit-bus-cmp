package org.ericho.recipeappcmp

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.koinInject
import org.koin.compose.viewmodel.koinViewModel
import org.ericho.recipeappcmp.features.app.data.rememberAppState
import org.ericho.recipeappcmp.features.app.navigation.AppNavHost
import org.ericho.recipeappcmp.features.designSystem.theme.RecipeAppCMPTheme
import org.ericho.recipeappcmp.features.login.ui.LoginScreenModalBottomSheet
import org.ericho.recipeappcmp.features.login.ui.LoginViewModel


@Composable
@Preview
fun App(
    loginViewModel: LoginViewModel = koinViewModel(),
    navController: NavHostController = rememberNavController()
) {


    RecipeAppCMPTheme {

            //val navController = rememberNavController()
            val appState = rememberAppState(
                navController,
                scope = rememberCoroutineScope(),
                appPreferences = koinInject()
            )

            var showLoginBottomSheet by remember {
                mutableStateOf(false)
            }

            val isLoggedIn by appState.isLoggedIn.collectAsState()

            val isUserLoggedIn: () -> Boolean = {
                isLoggedIn
            }

            var loginCallback : () -> Unit by remember {
                mutableStateOf({})
            }

            val openLoginBottomSheet: (() -> Unit) -> Unit = { laterCallback ->
                showLoginBottomSheet = true
                loginCallback = laterCallback
            }

            val onLoginSuccess: () -> Unit = {
                println("onLoginSuccess")
                showLoginBottomSheet = false
                appState.updateIsLoggedIn(true)
                loginViewModel.resetState()
                loginCallback()
            }

            val onLogout: () -> Unit = {
                appState.onLogout()
                loginViewModel.resetState()
            }

            val onCloseSheet: () -> Unit = {
                showLoginBottomSheet = false
                loginViewModel.resetState()
            }

            LoginScreenModalBottomSheet(
                loginViewModel = loginViewModel,
                showBottomSheet = showLoginBottomSheet,
                onClose = onCloseSheet,
                onLoginSuccess = onLoginSuccess
            )

            AppNavHost(
                appState = appState,
                isUserLoggedIn = isUserLoggedIn,
                openLoginBottomSheet = openLoginBottomSheet,
                onLogout = onLogout
            )


    }
}