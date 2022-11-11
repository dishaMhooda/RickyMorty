package com.disha.rickymorty.presentation.di.locations

import com.disha.rickymorty.domain.usecase.GetEpisodeUseCase
import com.disha.rickymorty.domain.usecase.GetLocationUseCase
import com.disha.rickymorty.domain.usecase.UpdateEpisodeUseCase
import com.disha.rickymorty.domain.usecase.UpdateLocationUseCase
import com.disha.rickymorty.presentation.episodes.EpisodesViewModelFactory
import com.disha.rickymorty.presentation.locations.LocationViewModelFactory
import dagger.Module
import dagger.Provides


@Module
class LocationModule {
    @LocationScope
    @Provides
    fun provideLocationViewModelFactory(
        getLocationUseCase: GetLocationUseCase,
        updateLocationUseCase: UpdateLocationUseCase
    ): LocationViewModelFactory {
        return LocationViewModelFactory(
            getLocationUseCase,
            updateLocationUseCase
        )
    }

}
