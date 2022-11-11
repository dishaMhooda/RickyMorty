package com.disha.rickymorty.data.repository.locations.datasource

import com.disha.rickymorty.data.model.episode.EpisodesList
import com.disha.rickymorty.data.model.location.Locations
import com.disha.rickymorty.data.model.location.LocationsList

interface LocationsCacheDataSource {

    suspend fun getLocationsFromCache(): Locations

    suspend fun saveLocationssToCache(locations: Locations)
}