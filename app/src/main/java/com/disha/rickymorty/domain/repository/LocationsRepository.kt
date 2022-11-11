package com.disha.rickymorty.domain.repository

import com.disha.rickymorty.data.model.location.Locations

interface LocationsRepository {

    suspend fun getLocations():Locations?
    suspend fun updateLocations():Locations?
}