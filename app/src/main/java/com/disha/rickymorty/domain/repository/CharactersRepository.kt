package com.disha.rickymorty.domain.repository

import com.disha.rickymorty.data.model.character.Characters
import com.disha.rickymorty.data.model.character.CharactersList

interface CharactersRepository {

    suspend fun getCharacters():Characters?
    suspend fun updateCharacters():Characters?
}