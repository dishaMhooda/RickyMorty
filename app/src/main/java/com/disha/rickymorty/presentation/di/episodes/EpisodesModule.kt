package com.disha.rickymorty.presentation.di.episodes

import com.disha.rickymorty.domain.usecase.GetEpisodeUseCase
import com.disha.rickymorty.domain.usecase.UpdateEpisodeUseCase
import com.disha.rickymorty.presentation.episodes.EpisodesViewModelFactory
import dagger.Module
import dagger.Provides


@Module
class EpisodesModule {
    @EpisodeScope
    @Provides
    fun provideEpisodesViewModelFactory(
        getEpisodeUseCase: GetEpisodeUseCase,
        updateEpisodeUseCase: UpdateEpisodeUseCase
    ): EpisodesViewModelFactory {
        return EpisodesViewModelFactory(
            getEpisodeUseCase,
            updateEpisodeUseCase
        )
    }

}
