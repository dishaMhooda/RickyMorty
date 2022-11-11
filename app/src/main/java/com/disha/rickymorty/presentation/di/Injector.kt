package com.disha.rickymorty.presentation.di

import com.disha.rickymorty.presentation.di.characters.CharacterSubComponent
import com.disha.rickymorty.presentation.di.episodes.EpisodeSubComponent
import com.disha.rickymorty.presentation.di.locations.LocationSubComponent


interface Injector {
   fun createCharacterSubComponent():CharacterSubComponent
   fun createEpisodeSubComponent():EpisodeSubComponent
   fun createLocationSubComponent():LocationSubComponent
}