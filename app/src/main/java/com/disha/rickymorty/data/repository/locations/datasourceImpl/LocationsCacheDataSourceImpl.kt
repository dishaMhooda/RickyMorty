package com.disha.rickymorty.data.repository.locations.datasourceImpl


import com.disha.rickymorty.data.model.location.Locations
import com.disha.rickymorty.data.repository.locations.datasource.LocationsCacheDataSource

class LocationsCacheDataSourceImpl : LocationsCacheDataSource {
    private lateinit var locationsList : Locations
    override suspend fun getLocationsFromCache(): Locations {
        return locationsList;
    }

    override suspend fun saveLocationssToCache(locations: Locations) {
        locationsList = locations
    }


}