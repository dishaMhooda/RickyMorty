package com.disha.rickymorty.data.repository.locations.datasourceImpl

import com.disha.rickymorty.data.api.RockyMortyService
import com.disha.rickymorty.data.model.character.Characters
import com.disha.rickymorty.data.model.character.Location
import com.disha.rickymorty.data.model.location.Locations
import com.disha.rickymorty.data.repository.characters.datasource.CharactersRemoteDataSource
import com.disha.rickymorty.data.repository.locations.datasource.LocationsRemoteDataSource
import retrofit2.Response

class LocationsRemoteDataSourceImpl(private val rockyMortyService: RockyMortyService):
    LocationsRemoteDataSource {
    override suspend fun getAllLocations(): Response<Locations> {
        return rockyMortyService.getAllLocations()
    }

}