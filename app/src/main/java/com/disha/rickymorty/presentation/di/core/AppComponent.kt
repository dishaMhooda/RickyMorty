package com.disha.rickymorty.presentation.di.core

import com.disha.rickymorty.presentation.di.characters.CharacterSubComponent
import com.disha.rickymorty.presentation.di.episodes.EpisodeSubComponent
import com.disha.rickymorty.presentation.di.locations.LocationSubComponent
import dagger.Component
import javax.inject.Singleton


@Singleton
@Component(modules = [
AppModule::class,
NetModule::class,
UseCaseModule::class,
RepositoryModule::class,
RemoteDataModule::class,
LocalDataModule::class,
CacheDataModule::class,
    DataBaseModule::class,
])
interface AppComponent {

fun characterSubComponent(): CharacterSubComponent.Factory
fun episodeSubComponent():EpisodeSubComponent.Factory
fun locationSubComponent():LocationSubComponent.Factory


}
