package com.disha.rickymorty.data.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.TypeConverters
import com.disha.rickymorty.data.model.character.Characters
import com.disha.rickymorty.data.model.character.CharactersList
import com.disha.rickymorty.util.Converters
import kotlinx.coroutines.flow.Flow

@Dao
interface CharactersDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveCharacters(characters : Characters)

    @Query("DELETE FROM characters")
    suspend fun deleteCharacters()

    @Query("Select * from characters")
    suspend fun getAllCharacters(): Characters
}