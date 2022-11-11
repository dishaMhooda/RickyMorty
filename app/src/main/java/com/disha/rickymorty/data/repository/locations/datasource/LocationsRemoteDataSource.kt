package com.disha.rickymorty.data.repository.locations.datasource

import com.disha.rickymorty.data.model.episode.Episodes
import com.disha.rickymorty.data.model.location.Locations
import retrofit2.Response

interface LocationsRemoteDataSource {

    suspend fun getAllLocations():Response<Locations>


}
