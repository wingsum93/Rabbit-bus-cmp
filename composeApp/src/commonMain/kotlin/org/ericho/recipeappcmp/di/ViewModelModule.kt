package org.ericho.recipeappcmp.di

import org.ericho.recipeappcmp.features.busroute.BusRouteViewModel
import org.ericho.recipeappcmp.features.detail.ui.RecipeDetailViewModel
import org.ericho.recipeappcmp.features.favorites.ui.FavoritesScreenViewModel
import org.ericho.recipeappcmp.features.feed.ui.FeedViewModel
import org.ericho.recipeappcmp.features.login.ui.LoginViewModel
import org.ericho.recipeappcmp.features.profile.ui.ProfileViewModel
import org.ericho.recipeappcmp.features.search.ui.SearchViewModel
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

fun viewModelModule()  = module {
    viewModel {
        BusRouteViewModel(get())
    }


    viewModel {
        FeedViewModel(get())
    }

    viewModel {
        RecipeDetailViewModel(get())
    }

    viewModel {
        FavoritesScreenViewModel(get())
    }

    viewModel {
        ProfileViewModel()
    }

    viewModel {
        LoginViewModel()
    }
    viewModel {
        SearchViewModel(get())
    }

}