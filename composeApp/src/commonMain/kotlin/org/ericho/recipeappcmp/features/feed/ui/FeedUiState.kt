package org.ericho.recipeappcmp.features.feed.ui

import org.ericho.recipeappcmp.features.common.domain.entities.RecipeItem

data class FeedUiState(
    val recipesList: List<RecipeItem>? = null,
    val recipesListIsLoading: Boolean = true,
    val recipesListError: String? = null,
)