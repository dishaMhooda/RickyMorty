package com.disha.rickymorty.data.repository.characters.datasource

import com.disha.rickymorty.data.model.character.Characters
import retrofit2.Response

interface CharactersRemoteDataSource {

    suspend fun getAllCharacters():Response<Characters>


}
