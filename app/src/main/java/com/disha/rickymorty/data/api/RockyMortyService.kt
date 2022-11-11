package com.disha.rickymorty.data.api

import com.disha.rickymorty.data.model.character.Characters
import com.disha.rickymorty.data.model.episode.Episodes
import com.disha.rickymorty.data.model.location.Locations
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface RockyMortyService {

    @GET("character")
    suspend fun getAllCharacters(): Response<Characters>

    @GET("character/{value}")
    suspend fun getAllCharacters(@Path("value")values : String): Response<Characters>

    @GET("location")
    suspend fun getAllLocations(): Response<Locations>

    @GET("location/{value}")
    suspend fun getAllLocations(@Path("value")values : String): Response<Locations>

    @GET("episode")
    suspend fun getAllEpisodes(): Response<Episodes>

    @GET("episode/{value}")
    suspend fun getAllEpisodes(@Path("value")values : String): Response<Episodes>



}