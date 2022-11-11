package com.disha.rickymorty.data.repository.episodes.datasourceImpl

import com.disha.rickymorty.data.api.RockyMortyService
import com.disha.rickymorty.data.model.character.Characters
import com.disha.rickymorty.data.model.episode.Episodes
import com.disha.rickymorty.data.repository.characters.datasource.CharactersRemoteDataSource
import com.disha.rickymorty.data.repository.episodes.datasource.EpisodesRemoteDataSource
import retrofit2.Response

class EpisodesRemoteDataSourceImpl(private val rockyMortyService: RockyMortyService):
    EpisodesRemoteDataSource {
    override suspend fun getAllEpisodes(): Response<Episodes> {
        return rockyMortyService.getAllEpisodes()
    }

}