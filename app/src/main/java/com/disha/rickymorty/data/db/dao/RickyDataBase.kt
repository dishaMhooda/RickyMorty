package com.disha.rickymorty.data.db.dao

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.disha.rickymorty.data.model.character.Characters
import com.disha.rickymorty.data.model.episode.Episodes
import com.disha.rickymorty.data.model.location.Locations
import com.disha.rickymorty.util.Converters

@Database(entities = [Characters::class , Episodes::class, Locations::class], version = 1 , exportSchema = false)
@TypeConverters(Converters::class)
abstract class RickyDataBase : RoomDatabase() {
    abstract val characterDao : CharactersDao
    abstract val locationDao : LocationDao
    abstract val episodeDao : EpisodeDao

    companion object{
        @Volatile
        private var INSTANCE : RickyDataBase? = null
        fun getInstance(context: Context):RickyDataBase{
            synchronized(this){
                var instance = INSTANCE
                if(instance==null){
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        RickyDataBase::class.java,
                        "subscriber_data_database"
                    ).build()
                    INSTANCE = instance
                }
                return instance
            }
        }
    }

}