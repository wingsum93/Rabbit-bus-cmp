package org.ericho.recipeappcmp.features.favorites.domain

import org.ericho.recipeappcmp.features.common.domain.entities.RecipeItem

interface FavoriteRecipeRepository {
    suspend fun getAllFavoriteRecipes(): Result<List<RecipeItem>>
    suspend fun addFavorite(recipeId: Long)
    suspend fun removeFavorite(recipeId: Long)
}