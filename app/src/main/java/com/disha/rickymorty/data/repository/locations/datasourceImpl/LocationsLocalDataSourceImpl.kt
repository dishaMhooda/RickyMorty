package com.disha.rickymorty.data.repository.locations.datasourceImpl

import com.disha.rickymorty.data.db.dao.LocationDao
import com.disha.rickymorty.data.model.episode.EpisodesList
import com.disha.rickymorty.data.model.location.Locations
import com.disha.rickymorty.data.model.location.LocationsList
import com.disha.rickymorty.data.repository.locations.datasource.LocationsLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LocationsLocalDataSourceImpl(private val locationDao: LocationDao) :
    LocationsLocalDataSource {


    override suspend fun getAllLocationsFromDB(): Locations {
        return locationDao.getAllLocations()
    }

    override suspend fun saveLocationsToDB(locations: Locations) {
        CoroutineScope(Dispatchers.IO).launch {
            locationDao.saveLocation(locations)
        }
    }

}
