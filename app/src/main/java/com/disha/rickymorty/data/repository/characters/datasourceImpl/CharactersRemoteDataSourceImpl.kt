package com.disha.rickymorty.data.repository.characters.datasourceImpl

import com.disha.rickymorty.data.api.RockyMortyService
import com.disha.rickymorty.data.model.character.Characters
import com.disha.rickymorty.data.repository.characters.datasource.CharactersRemoteDataSource
import retrofit2.Response

class CharactersRemoteDataSourceImpl(private val rockyMortyService: RockyMortyService):
    CharactersRemoteDataSource {
    override suspend fun getAllCharacters(): Response<Characters> {
        return rockyMortyService.getAllCharacters()
    }

}