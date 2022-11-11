package com.disha.rickymorty.data.db.dao

import androidx.room.*
import com.disha.rickymorty.data.model.character.Characters
import com.disha.rickymorty.data.model.location.Locations
import com.disha.rickymorty.util.Converters

@Dao
@TypeConverters(Converters::class)
interface LocationDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveLocation(locations : Locations)

    @Query("DELETE FROM locations")
    suspend fun deleteLocations()

    @Query("Select * from locations")
    suspend fun getAllLocations():Locations


}