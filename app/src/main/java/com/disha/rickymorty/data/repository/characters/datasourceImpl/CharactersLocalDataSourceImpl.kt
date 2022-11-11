package com.disha.rickymorty.data.repository.characters.datasourceImpl

import com.disha.rickymorty.data.db.dao.CharactersDao
import com.disha.rickymorty.data.model.character.Characters
import com.disha.rickymorty.data.model.character.CharactersList
import com.disha.rickymorty.data.repository.characters.datasource.CharactersLocalDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CharactersLocalDataSourceImpl(private val charactersDao: CharactersDao) :
    CharactersLocalDataSource {
    override suspend fun getAllCharactersFromDB(): Characters {
        return charactersDao.getAllCharacters()
    }

    override suspend fun saveCharactersToDB(characters: Characters) {
       CoroutineScope(Dispatchers.IO).launch {
           charactersDao.saveCharacters(characters)
       }
    }
}