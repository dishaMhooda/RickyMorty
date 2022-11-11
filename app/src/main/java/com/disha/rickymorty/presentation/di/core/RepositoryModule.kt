package com.disha.rickymorty.presentation.di.core

import com.disha.rickymorty.data.repository.characters.CharactersRepositoryImpl
import com.disha.rickymorty.data.repository.characters.datasource.CharactersCacheDataSource
import com.disha.rickymorty.data.repository.characters.datasource.CharactersLocalDataSource
import com.disha.rickymorty.data.repository.characters.datasource.CharactersRemoteDataSource
import com.disha.rickymorty.data.repository.episodes.EpisodesRepositoryImpl
import com.disha.rickymorty.data.repository.episodes.datasource.EpisodesCacheDataSource
import com.disha.rickymorty.data.repository.episodes.datasource.EpisodesLocalDataSource
import com.disha.rickymorty.data.repository.episodes.datasource.EpisodesRemoteDataSource
import com.disha.rickymorty.data.repository.locations.LocationsRepositoryImpl
import com.disha.rickymorty.data.repository.locations.datasource.LocationsCacheDataSource
import com.disha.rickymorty.data.repository.locations.datasource.LocationsLocalDataSource
import com.disha.rickymorty.data.repository.locations.datasource.LocationsRemoteDataSource
import com.disha.rickymorty.domain.repository.CharactersRepository
import com.disha.rickymorty.domain.repository.EpisodesRepository
import com.disha.rickymorty.domain.repository.LocationsRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class RepositoryModule {

  @Provides
    @Singleton
    fun provideCharactersRepository(
        charactersRemoteDataSource: CharactersRemoteDataSource,
        charactersLocalDataSource: CharactersLocalDataSource,
        charactersCacheDataSource: CharactersCacheDataSource
    ): CharactersRepository {

        return CharactersRepositoryImpl(
            charactersLocalDataSource,
            charactersCacheDataSource,
            charactersRemoteDataSource
        )


    }

    @Provides
    @Singleton
    fun provideEpisodeRepository(
        episodesRemoteDatasource: EpisodesRemoteDataSource,
        episodesLocalDataSource: EpisodesLocalDataSource,
        episodesCacheDataSource: EpisodesCacheDataSource
    ): EpisodesRepository {

        return EpisodesRepositoryImpl(
            episodesRemoteDatasource,
            episodesLocalDataSource,
            episodesCacheDataSource
        )


    }

    @Provides
    @Singleton
    fun provideLocationRepository(
        locationRemoteDataSoure: LocationsRemoteDataSource,
        locationLocalDataSource: LocationsLocalDataSource,
        locationsCacheDataSource: LocationsCacheDataSource
    ): LocationsRepository {

        return LocationsRepositoryImpl(
            locationRemoteDataSoure,
            locationLocalDataSource,
            locationsCacheDataSource
        )


    }


}
