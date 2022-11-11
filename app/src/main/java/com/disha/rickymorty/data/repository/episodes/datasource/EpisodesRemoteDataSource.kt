package com.disha.rickymorty.data.repository.episodes.datasource

import com.disha.rickymorty.data.model.episode.Episodes
import retrofit2.Response

interface EpisodesRemoteDataSource {

    suspend fun getAllEpisodes():Response<Episodes>


}
