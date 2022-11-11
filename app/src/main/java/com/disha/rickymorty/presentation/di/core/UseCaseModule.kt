package com.disha.rickymorty.presentation.di.core

import com.disha.rickymorty.domain.repository.CharactersRepository
import com.disha.rickymorty.domain.repository.EpisodesRepository
import com.disha.rickymorty.domain.repository.LocationsRepository
import com.disha.rickymorty.domain.usecase.*
import dagger.Module
import dagger.Provides


@Module
class UseCaseModule {

 @Provides
    fun provideGetCharactersUseCase(charactersRepository: CharactersRepository):GetCharactersUseCase{
        return GetCharactersUseCase(charactersRepository)
    }
    @Provides
    fun provideUpdateCharactersUseCase(charactersRepository: CharactersRepository):UpdateCharactersUseCase{
        return UpdateCharactersUseCase(charactersRepository)
    }

    @Provides
    fun provideGetEpisodesUseCase(episodesRepository: EpisodesRepository):GetEpisodeUseCase{
        return GetEpisodeUseCase(episodesRepository)
    }
    @Provides
    fun provideUpdateEpisodesUseCase(episodesRepository: EpisodesRepository):UpdateEpisodeUseCase{
        return UpdateEpisodeUseCase(episodesRepository)
    }

    @Provides
    fun provideGetLocationsUseCase(locationsRepository: LocationsRepository):GetLocationUseCase{
        return GetLocationUseCase(locationsRepository)
    }
    @Provides
    fun provideUpdateLocationUseCase(locationsRepository: LocationsRepository):UpdateLocationUseCase{
        return UpdateLocationUseCase(locationsRepository)
    }


}
