package com.disha.rickymorty.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.disha.rickymorty.data.db.dao.CharactersDao
import com.disha.rickymorty.data.db.dao.EpisodeDao
import com.disha.rickymorty.data.db.dao.LocationDao
import com.disha.rickymorty.data.model.character.Characters
import com.disha.rickymorty.data.model.episode.Episodes
import com.disha.rickymorty.data.model.location.Locations
import com.disha.rickymorty.util.Converters


@Database(entities = [Characters::class ,Episodes::class, Locations::class], version = 1)

abstract class RickyMortyDatabase : RoomDatabase(){

    abstract fun characterDao() : CharactersDao
    abstract fun locationDao() : LocationDao
    abstract fun episodeDao() : EpisodeDao
}