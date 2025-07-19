package org.ericho.recipeappcmp.features.busroute

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import org.ericho.recipeappcmp.data.BusRepository

class BusRouteViewModel(
    private val busRepository: BusRepository
) : ViewModel() {

    private var _uiState = MutableStateFlow(BusRouteUiState())
    val uiState = _uiState.asStateFlow()

    init {
        loadAllBusRoutes()
    }


    private fun loadAllBusRoutes() {
        viewModelScope.launch {
            _uiState.value = _uiState.value.copy(isLoading = true)
            val busRoutesResult = busRepository.getAllBusRoutes()
            if (busRoutesResult.isSuccess) {
                _uiState.value = _uiState.value.copy(
                    busRoutes = busRoutesResult.getOrDefault(emptyList()),
                    isLoading = false
                )
            } else {
                _uiState.value = _uiState.value.copy(
                    errorMessage = busRoutesResult.exceptionOrNull()?.message,
                    isLoading = false
                )
            }
        }
    }
}