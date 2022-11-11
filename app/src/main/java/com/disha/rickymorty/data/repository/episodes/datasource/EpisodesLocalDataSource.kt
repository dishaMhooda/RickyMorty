package com.disha.rickymorty.data.repository.episodes.datasource

import com.disha.rickymorty.data.model.character.CharactersList
import com.disha.rickymorty.data.model.episode.Episodes
import com.disha.rickymorty.data.model.episode.EpisodesList

interface EpisodesLocalDataSource {

    suspend fun getAllEpisodesFromDB(): Episodes
    suspend fun saveEpisodesToDB(episodes: Episodes)
}