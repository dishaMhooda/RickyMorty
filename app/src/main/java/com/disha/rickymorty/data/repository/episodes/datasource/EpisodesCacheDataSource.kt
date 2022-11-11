package com.disha.rickymorty.data.repository.episodes.datasource


import com.disha.rickymorty.data.model.episode.Episodes
import com.disha.rickymorty.data.model.episode.EpisodesList

interface EpisodesCacheDataSource {

    suspend fun getEpisodesFromCache():Episodes

    suspend fun saveEpisodesToCache(episodes: Episodes)
}