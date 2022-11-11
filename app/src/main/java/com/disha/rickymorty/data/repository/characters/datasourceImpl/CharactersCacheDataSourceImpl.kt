package com.disha.rickymorty.data.repository.characters.datasourceImpl

import com.disha.rickymorty.data.model.character.Characters
import com.disha.rickymorty.data.repository.characters.datasource.CharactersCacheDataSource

class CharactersCacheDataSourceImpl : CharactersCacheDataSource {
 private lateinit var characterList : Characters
    override suspend fun getCharactersFromCache(): Characters {
        return characterList;
    }

    override suspend fun saveCharactersToCache(characters: Characters) {
      //  characterList.clear()
        characterList = characters
    }

}
