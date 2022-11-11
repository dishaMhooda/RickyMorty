package com.disha.rickymorty.data.repository.characters.datasource

import com.disha.rickymorty.data.model.character.Characters
import com.disha.rickymorty.data.model.character.CharactersList

interface CharactersLocalDataSource {

    suspend fun getAllCharactersFromDB():Characters
    suspend fun saveCharactersToDB(characters: Characters)
}