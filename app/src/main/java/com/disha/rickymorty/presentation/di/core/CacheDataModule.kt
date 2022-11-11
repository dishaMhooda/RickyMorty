package com.disha.rickymorty.presentation.di.core

import com.disha.rickymorty.data.repository.characters.datasource.CharactersCacheDataSource
import com.disha.rickymorty.data.repository.characters.datasourceImpl.CharactersCacheDataSourceImpl
import com.disha.rickymorty.data.repository.episodes.datasource.EpisodesCacheDataSource
import com.disha.rickymorty.data.repository.episodes.datasourceImpl.EpisodesCacheDataSourceImpl
import com.disha.rickymorty.data.repository.locations.datasource.LocationsCacheDataSource
import com.disha.rickymorty.data.repository.locations.datasourceImpl.LocationsCacheDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class CacheDataModule {
    @Singleton
    @Provides
    fun providecharactersCacheDataSource(): CharactersCacheDataSource {
        return CharactersCacheDataSourceImpl()
    }

    @Singleton
    @Provides
    fun provideEpisodesCacheDataSource(): EpisodesCacheDataSource {
        return EpisodesCacheDataSourceImpl()
    }

    @Singleton
    @Provides
    fun provideLocationsCacheDataSource(): LocationsCacheDataSource {
        return LocationsCacheDataSourceImpl()
    }


}
