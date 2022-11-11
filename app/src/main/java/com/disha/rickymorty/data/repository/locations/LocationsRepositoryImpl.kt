package com.disha.rickymorty.data.repository.locations



import com.disha.rickymorty.data.model.location.Locations
import com.disha.rickymorty.data.repository.locations.datasource.LocationsCacheDataSource
import com.disha.rickymorty.data.repository.locations.datasource.LocationsLocalDataSource
import com.disha.rickymorty.data.repository.locations.datasource.LocationsRemoteDataSource

import com.disha.rickymorty.domain.repository.LocationsRepository

class LocationsRepositoryImpl(
    private val locationsRemoteDataSource: LocationsRemoteDataSource,
    private val locationsLocalDataSource: LocationsLocalDataSource,
    private val locationsCacheDataSource: LocationsCacheDataSource

) : LocationsRepository {
    override suspend fun getLocations(): Locations? {
        return getLocationFromApi()
    }

    override suspend fun updateLocations(): Locations? {
        val fetchNewLocations = getLocationFromApi()
        locationsLocalDataSource.saveLocationsToDB(fetchNewLocations)
        locationsCacheDataSource.saveLocationssToCache(fetchNewLocations)
        return fetchNewLocations;
    }

    private suspend fun getLocationFromApi():Locations{
        lateinit var locationsList : Locations
        try{
            val response = locationsRemoteDataSource.getAllLocations()
            val body = response.body()
            if(body!=null){
                locationsList = body
            }
        }catch (exception : Exception){

        }
        return locationsList
    }

    private suspend fun getLocationsFromDB() : Locations{
        lateinit var locationsList : Locations
        try{
            locationsList = locationsLocalDataSource.getAllLocationsFromDB()
            if(locationsList!=null){
                return locationsList
            }else{
                locationsList = getLocationFromApi()
                locationsLocalDataSource.saveLocationsToDB(locationsList)
            }
        }catch (exception : Exception){

        }
        return locationsList
    }

    private suspend fun getLocationsFromCache() : Locations {
        lateinit var locationsList : Locations
        try{
            locationsList = locationsCacheDataSource.getLocationsFromCache()
            if(locationsList!=null && locationsList.results.isNotEmpty()){
                return locationsList
            }else{
                locationsList = getLocationsFromDB()
                locationsCacheDataSource.saveLocationssToCache(locationsList)
            }
        }catch (exception : Exception){

        }
        return locationsList
    }

}