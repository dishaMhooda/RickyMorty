package com.disha.rickymorty.presentation.di.episodes


import com.disha.rickymorty.presentation.episodes.EpisodesActivity
import dagger.Subcomponent


@EpisodeScope
@Subcomponent(modules = [EpisodesModule::class])
interface EpisodeSubComponent {
    fun inject(episodeActivity: EpisodesActivity)

    @Subcomponent.Factory
    interface Factory{
        fun create():EpisodeSubComponent
    }

}

