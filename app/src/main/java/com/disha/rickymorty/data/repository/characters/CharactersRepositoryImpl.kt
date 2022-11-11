package com.disha.rickymorty.data.repository.characters

import com.disha.rickymorty.data.model.character.Characters
import com.disha.rickymorty.data.repository.characters.datasource.CharactersCacheDataSource
import com.disha.rickymorty.data.repository.characters.datasource.CharactersLocalDataSource
import com.disha.rickymorty.data.repository.characters.datasource.CharactersRemoteDataSource
import com.disha.rickymorty.domain.repository.CharactersRepository

class CharactersRepositoryImpl(
    private val charactersLocalDataSource: CharactersLocalDataSource,
    private val charactersCacheDataSource: CharactersCacheDataSource,
    private val charactersRemoteDataSource: CharactersRemoteDataSource
) : CharactersRepository {
    override suspend fun getCharacters(): Characters? {
       return getCharactersFromApi()
    }

    override suspend fun updateCharacters(): Characters? {
        val fetchNewCharacters = getCharactersFromApi()
        charactersLocalDataSource.saveCharactersToDB(fetchNewCharacters)
        charactersCacheDataSource.saveCharactersToCache(fetchNewCharacters)
        return fetchNewCharacters;
    }

    suspend fun getCharactersFromApi():Characters{
        lateinit var charactersList : Characters
        try{
            val response = charactersRemoteDataSource.getAllCharacters()
            val body = response.body()
            if(body!=null){
                charactersList = body
            }
        }catch (exception : Exception){

        }
        return charactersList
    }

    suspend fun getCharactersFromDB() : Characters{
        lateinit var charactersList : Characters
        try{
           charactersList = charactersLocalDataSource.getAllCharactersFromDB()
            if(charactersList!=null){
                return charactersList
            }else{
                //charactersList = getCharactersFromApi()
                charactersLocalDataSource.saveCharactersToDB(charactersList)
            }
        }catch (exception : Exception){

        }
        return charactersList
    }

    suspend fun getCharactersFromCache() : Characters{
        lateinit var charactersList : Characters
        try{
            charactersList = charactersCacheDataSource.getCharactersFromCache()
            if(charactersList!=null){
                return charactersList
            }else{
                charactersList = getCharactersFromDB()
                charactersCacheDataSource.saveCharactersToCache(charactersList)
            }
        }catch (exception : Exception){

        }
        return charactersList
    }
}