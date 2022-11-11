package com.disha.rickymorty.presentation.di.core

import android.content.Context
import androidx.room.Room
import androidx.room.TypeConverters
import com.disha.rickymorty.data.db.RickyMortyDatabase
import com.disha.rickymorty.data.db.dao.CharactersDao
import com.disha.rickymorty.data.db.dao.EpisodeDao
import com.disha.rickymorty.data.db.dao.LocationDao
import com.disha.rickymorty.util.Converters
import com.disha.rickymorty.util.GsonParser
import com.disha.rickymorty.util.JsonParser
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import javax.inject.Inject
import javax.inject.Singleton


@Module
class DataBaseModule {
    @Singleton
    @Provides
    fun provideRickyMortyDataBase(context: Context):RickyMortyDatabase{

        return Room.databaseBuilder(context,RickyMortyDatabase::class.java,"ricky_mory")
            .addTypeConverter(Converters())
            .build()
    }
    @Singleton
    @Provides
    fun provideCharacterDao(rickyMortyDatabase: RickyMortyDatabase): CharactersDao{
        return rickyMortyDatabase.characterDao()
    }

    @Singleton
    @Provides
    fun provideEpisodeDao(rickyMortyDatabase: RickyMortyDatabase): EpisodeDao{
        return rickyMortyDatabase.episodeDao()
    }

    @Singleton
    @Provides
    fun provideLocationDao(rickyMortyDatabase: RickyMortyDatabase): LocationDao {
        return rickyMortyDatabase.locationDao()
    }





}
