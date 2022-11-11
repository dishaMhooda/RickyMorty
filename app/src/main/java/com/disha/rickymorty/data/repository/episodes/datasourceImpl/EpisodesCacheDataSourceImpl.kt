package com.disha.rickymorty.data.repository.episodes.datasourceImpl

import com.disha.rickymorty.data.model.character.Characters
import com.disha.rickymorty.data.model.character.CharactersList
import com.disha.rickymorty.data.model.episode.Episodes
import com.disha.rickymorty.data.model.episode.EpisodesList
import com.disha.rickymorty.data.repository.characters.datasource.CharactersCacheDataSource
import com.disha.rickymorty.data.repository.episodes.datasource.EpisodesCacheDataSource

class EpisodesCacheDataSourceImpl : EpisodesCacheDataSource {
    private lateinit var episodesList : Episodes
    override suspend fun getEpisodesFromCache(): Episodes {
        return episodesList;
    }

    override suspend fun saveEpisodesToCache(episodes: Episodes) {
        episodesList = episodes
    }
}