package org.ericho.recipeappcmp.di

import org.ericho.recipeappcmp.data.BusRepository
import org.ericho.recipeappcmp.data.BusRepositoryImpl
import org.ericho.recipeappcmp.data.local.BusLocalDataSource
import org.ericho.recipeappcmp.data.local.BusLocalDataSourceImpl
import org.ericho.recipeappcmp.data.remote.BusRemoteDataSource
import org.ericho.recipeappcmp.data.remote.BusRemoteDataSourceImpl
import org.ericho.recipeappcmp.features.detail.data.datasources.RecipeDetailLocalDataSource
import org.ericho.recipeappcmp.features.detail.data.datasources.RecipeDetailLocalDataSourceImpl
import org.ericho.recipeappcmp.features.detail.data.datasources.RecipeDetailRemoteDataSource
import org.ericho.recipeappcmp.features.detail.data.datasources.RecipeDetailRemoteDataSourceImpl
import org.ericho.recipeappcmp.features.detail.data.repositories.RecipeDetailRepositoryImpl
import org.ericho.recipeappcmp.features.detail.repositories.RecipeDetailRepository
import org.ericho.recipeappcmp.features.favorites.data.FavoriteRecipeLocalDataSource
import org.ericho.recipeappcmp.features.favorites.data.FavoriteRecipeLocalDataSourceImpl
import org.ericho.recipeappcmp.features.favorites.data.FavoriteRecipeRepositoryImpl
import org.ericho.recipeappcmp.features.favorites.domain.FavoriteRecipeRepository
import org.ericho.recipeappcmp.features.feed.data.datasources.FeedLocalDataSource
import org.ericho.recipeappcmp.features.feed.data.datasources.FeedLocalDataSourceImpl
import org.ericho.recipeappcmp.features.feed.data.datasources.FeedRemoteDataSource
import org.ericho.recipeappcmp.features.feed.data.datasources.FeedRemoteDataSourceImpl
import org.ericho.recipeappcmp.features.feed.data.repositories.FeedRepositoryImpl
import org.ericho.recipeappcmp.features.feed.domain.repositories.FeedRepository
import org.ericho.recipeappcmp.features.search.data.datasources.SearchRecipeLocalDataSource
import org.ericho.recipeappcmp.features.search.data.datasources.SearchRecipeLocalDataSourceImpl
import org.ericho.recipeappcmp.features.search.data.repositories.SearchRecipeRepositoryImpl
import org.ericho.recipeappcmp.features.search.domain.repositories.SearchRecipeRepository
import org.ericho.recipeappcmp.preferences.AppPreferences
import org.ericho.recipeappcmp.preferences.AppPreferencesImpl
import org.koin.dsl.module

fun dataModule() = module {

    single<AppPreferences> { AppPreferencesImpl(get()) }

    single<FeedLocalDataSource> { FeedLocalDataSourceImpl(get()) }
    single<FeedRemoteDataSource> { FeedRemoteDataSourceImpl(get()) }

    single<RecipeDetailLocalDataSource> { RecipeDetailLocalDataSourceImpl(get(), get()) }
    single<RecipeDetailRemoteDataSource> { RecipeDetailRemoteDataSourceImpl(get()) }

    single<FavoriteRecipeLocalDataSource> { FavoriteRecipeLocalDataSourceImpl(get()) }

    single<FeedRepository> { FeedRepositoryImpl(get(), get()) }
    single<RecipeDetailRepository> { RecipeDetailRepositoryImpl(get(), get()) }
    single<FavoriteRecipeRepository> { FavoriteRecipeRepositoryImpl(get()) }

    single<SearchRecipeLocalDataSource> { SearchRecipeLocalDataSourceImpl(get()) }
    single<SearchRecipeRepository> { SearchRecipeRepositoryImpl(get()) }

    //Bus part
    single<BusLocalDataSource> { BusLocalDataSourceImpl(get()) }
    single<BusRemoteDataSource> { BusRemoteDataSourceImpl(get()) }
    single<BusRepository> { BusRepositoryImpl(get(), get()) }
}