package com.disha.rickymorty.domain.repository

import com.disha.rickymorty.data.model.episode.Episodes

interface EpisodesRepository {

    suspend fun getEpisodes():Episodes?
    suspend fun updateEpisodes():Episodes?

}