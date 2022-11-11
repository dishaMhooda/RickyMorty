package com.disha.rickymorty.data.repository.locations.datasource

import com.disha.rickymorty.data.model.episode.EpisodesList
import com.disha.rickymorty.data.model.location.Locations
import com.disha.rickymorty.data.model.location.LocationsList

interface LocationsLocalDataSource {

    suspend fun getAllLocationsFromDB():Locations
    suspend fun saveLocationsToDB(locations: Locations)
}