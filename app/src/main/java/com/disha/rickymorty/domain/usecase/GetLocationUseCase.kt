package com.disha.rickymorty.domain.usecase

import com.disha.rickymorty.data.model.location.Locations
import com.disha.rickymorty.domain.repository.LocationsRepository

class GetLocationUseCase(private val locationsRepository: LocationsRepository) {

    suspend fun execute():Locations ? = locationsRepository.getLocations()
}