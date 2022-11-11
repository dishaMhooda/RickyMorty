package com.disha.rickymorty.presentation.di.locations

import com.disha.rickymorty.presentation.di.characters.CharacterScope
import com.disha.rickymorty.presentation.episodes.EpisodesActivity
import com.disha.rickymorty.presentation.locations.LocationsActivity
import dagger.Subcomponent


@LocationScope
@Subcomponent(modules = [LocationModule::class])
interface LocationSubComponent {
    fun inject(locationActivity: LocationsActivity)

    @Subcomponent.Factory
    interface Factory{
        fun create():LocationSubComponent
    }

}

