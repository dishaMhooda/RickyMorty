package com.disha.rickymorty.data.repository.episodes


import com.disha.rickymorty.data.model.character.Characters
import com.disha.rickymorty.data.model.episode.Episodes
import com.disha.rickymorty.data.repository.episodes.datasource.EpisodesCacheDataSource
import com.disha.rickymorty.data.repository.episodes.datasource.EpisodesLocalDataSource
import com.disha.rickymorty.data.repository.episodes.datasource.EpisodesRemoteDataSource

import com.disha.rickymorty.domain.repository.EpisodesRepository

class EpisodesRepositoryImpl(
    private val episodesRemoteDataSource: EpisodesRemoteDataSource,
    private val episodesLocalDataSource: EpisodesLocalDataSource,
    private val episodeCacheDataSource: EpisodesCacheDataSource

) : EpisodesRepository {
    override suspend fun getEpisodes(): Episodes? {
        return getEpisodesFromApi()
    }

    override suspend fun updateEpisodes(): Episodes? {
        val fetchNewEpisodes = getEpisodesFromApi()
        episodesLocalDataSource.saveEpisodesToDB(fetchNewEpisodes)
        episodeCacheDataSource.saveEpisodesToCache(fetchNewEpisodes)
        return fetchNewEpisodes;
    }

    suspend fun getEpisodesFromApi():Episodes{
        lateinit var episodesList : Episodes
        try{
            val response = episodesRemoteDataSource.getAllEpisodes()
            val body = response.body()
            if(body!=null){
                episodesList = body
            }
        }catch (exception : Exception){

        }
        return episodesList
    }

    suspend fun getEpisodesFromDB() : Episodes{
        lateinit var episodesList : Episodes
        try{
            episodesList = episodesLocalDataSource.getAllEpisodesFromDB()
            if(episodesList!=null){
                return episodesList
            }else{
                //charactersList = getCharactersFromApi()
                episodesLocalDataSource.saveEpisodesToDB(episodesList)
            }
        }catch (exception : Exception){

        }
        return episodesList
    }

    suspend fun getEpisodesFromCache() : Episodes {
        lateinit var episodesList : Episodes
        try{
            episodesList = episodeCacheDataSource.getEpisodesFromCache()
            if(episodesList!=null){
                return episodesList
            }else{
                episodesList = getEpisodesFromDB()
                episodeCacheDataSource.saveEpisodesToCache(episodesList)
            }
        }catch (exception : Exception){

        }
        return episodesList
    }
}