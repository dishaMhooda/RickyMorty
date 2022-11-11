package com.disha.rickymorty.presentation.di.core

import com.disha.rickymorty.data.api.RockyMortyService
import com.disha.rickymorty.data.repository.characters.datasource.CharactersRemoteDataSource
import com.disha.rickymorty.data.repository.characters.datasourceImpl.CharactersRemoteDataSourceImpl
import com.disha.rickymorty.data.repository.episodes.datasource.EpisodesRemoteDataSource
import com.disha.rickymorty.data.repository.episodes.datasourceImpl.EpisodesRemoteDataSourceImpl
import com.disha.rickymorty.data.repository.locations.datasource.LocationsRemoteDataSource
import com.disha.rickymorty.data.repository.locations.datasourceImpl.LocationsRemoteDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class RemoteDataModule() {
    @Singleton
    @Provides
    fun provideCharacterRemoteDataSource(rockyMortyService: RockyMortyService): CharactersRemoteDataSource {
        return CharactersRemoteDataSourceImpl(
            rockyMortyService
        )
    }

    @Singleton
    @Provides
    fun provideEpisodeRemoteDataSource(rockyMortyService: RockyMortyService): EpisodesRemoteDataSource {
        return EpisodesRemoteDataSourceImpl(
            rockyMortyService
        )
    }

    @Singleton
    @Provides
    fun provideLocationsRemoteDataSource(rockyMortyService: RockyMortyService): LocationsRemoteDataSource {
        return LocationsRemoteDataSourceImpl(
            rockyMortyService
        )
    }


}
