package com.disha.rickymorty.data.repository.characters.datasource

import com.disha.rickymorty.data.model.character.Characters
import com.disha.rickymorty.data.model.character.CharactersList

interface CharactersCacheDataSource {

    suspend fun getCharactersFromCache():Characters

    suspend fun saveCharactersToCache(characters: Characters)
}