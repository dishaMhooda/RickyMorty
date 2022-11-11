package com.disha.rickymorty.data.repository.episodes.datasourceImpl

import com.disha.rickymorty.data.db.dao.CharactersDao
import com.disha.rickymorty.data.db.dao.EpisodeDao
import com.disha.rickymorty.data.model.character.CharactersList
import com.disha.rickymorty.data.model.episode.Episodes
import com.disha.rickymorty.data.model.episode.EpisodesList
import com.disha.rickymorty.data.repository.characters.datasource.CharactersLocalDataSource
import com.disha.rickymorty.data.repository.episodes.datasource.EpisodesLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class EpisodesLocalDataSourceImpl(private val episodeDao: EpisodeDao) :
    EpisodesLocalDataSource {
    override suspend fun getAllEpisodesFromDB(): Episodes {
        return episodeDao.getAllEpisodes()
    }

    override suspend fun saveEpisodesToDB(episodes: Episodes) {
       CoroutineScope(Dispatchers.IO).launch {
           episodeDao.saveEpisode(episodes)
       }
    }
}
