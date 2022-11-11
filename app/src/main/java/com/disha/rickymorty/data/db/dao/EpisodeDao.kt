package com.disha.rickymorty.data.db.dao

import androidx.room.*
import com.disha.rickymorty.data.model.character.Characters
import com.disha.rickymorty.data.model.episode.Episodes
import com.disha.rickymorty.data.model.episode.EpisodesList
import com.disha.rickymorty.util.Converters

@Dao
@TypeConverters(Converters::class)
interface EpisodeDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveEpisode(episodes : Episodes)

    @Query("DELETE FROM episodes")
    suspend fun deleteEpisodes()

    @Query("Select * from episodes")
    suspend fun getAllEpisodes():Episodes
}