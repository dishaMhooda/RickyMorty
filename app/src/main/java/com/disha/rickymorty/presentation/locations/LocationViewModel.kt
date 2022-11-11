package com.disha.rickymorty.presentation.locations

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.disha.rickymorty.domain.usecase.GetLocationUseCase
import com.disha.rickymorty.domain.usecase.UpdateLocationUseCase


class LocationViewModel(
    private val getLocationUseCase: GetLocationUseCase,
    private val updateLocationUseCase: UpdateLocationUseCase
): ViewModel() {

    fun getLocation() = liveData {
        val locationList = getLocationUseCase.execute()
        emit(locationList)
    }

    fun updateLocation() = liveData {
        val locationList = updateLocationUseCase.execute()
        emit(locationList)
    }

}
