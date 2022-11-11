package com.disha.rickymorty.presentation.locations

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.disha.rickymorty.domain.usecase.GetEpisodeUseCase
import com.disha.rickymorty.domain.usecase.GetLocationUseCase
import com.disha.rickymorty.domain.usecase.UpdateCharactersUseCase
import com.disha.rickymorty.domain.usecase.UpdateLocationUseCase

class LocationViewModelFactory (
    private val getLocationUseCase: GetLocationUseCase,
    private val updateLocationUseCase: UpdateLocationUseCase
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return LocationViewModel(getLocationUseCase,updateLocationUseCase) as T
    }
}
