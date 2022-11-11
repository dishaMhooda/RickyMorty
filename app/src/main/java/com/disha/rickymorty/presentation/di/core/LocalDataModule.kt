package com.disha.rickymorty.presentation.di.core

import com.disha.rickymorty.data.db.dao.CharactersDao
import com.disha.rickymorty.data.db.dao.EpisodeDao
import com.disha.rickymorty.data.db.dao.LocationDao
import com.disha.rickymorty.data.repository.characters.datasource.CharactersLocalDataSource
import com.disha.rickymorty.data.repository.characters.datasourceImpl.CharactersLocalDataSourceImpl
import com.disha.rickymorty.data.repository.episodes.EpisodesRepositoryImpl
import com.disha.rickymorty.data.repository.episodes.datasource.EpisodesLocalDataSource
import com.disha.rickymorty.data.repository.episodes.datasourceImpl.EpisodesLocalDataSourceImpl
import com.disha.rickymorty.data.repository.locations.datasource.LocationsLocalDataSource
import com.disha.rickymorty.data.repository.locations.datasourceImpl.LocationsLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class LocalDataModule {

    @Singleton
    @Provides
    fun provideCharactersLocalDataSource(charactersDao: CharactersDao): CharactersLocalDataSource {
        return CharactersLocalDataSourceImpl(charactersDao)
    }

    @Singleton
    @Provides
    fun provideEpisdeosLocalDataSource(episodeDao: EpisodeDao): EpisodesLocalDataSource{
        return EpisodesLocalDataSourceImpl(episodeDao)
    }

    @Singleton
    @Provides
    fun provideEpisodesLocalDataSource(locationDao: LocationDao):LocationsLocalDataSource{
        return LocationsLocalDataSourceImpl(locationDao)
    }


}
