package com.disha.rickymorty.presentation

import android.app.Application
import com.disha.rickymorty.BuildConfig
import com.disha.rickymorty.presentation.di.Injector

import com.disha.rickymorty.presentation.di.characters.CharacterSubComponent
import com.disha.rickymorty.presentation.di.core.*
import com.disha.rickymorty.presentation.di.core.AppModule
import com.disha.rickymorty.presentation.di.core.NetModule
import com.disha.rickymorty.presentation.di.episodes.EpisodeSubComponent
import com.disha.rickymorty.presentation.di.locations.LocationSubComponent

class App : Application(), Injector {
private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .appModule(AppModule(applicationContext))
            .remoteDataModule(RemoteDataModule())
            .netModule(NetModule(BuildConfig.BASE_URL))
            .build()

    }

    override fun createCharacterSubComponent(): CharacterSubComponent {
        return appComponent.characterSubComponent().create()
    }

    override fun createEpisodeSubComponent(): EpisodeSubComponent {
       return appComponent.episodeSubComponent().create()
    }

    override fun createLocationSubComponent(): LocationSubComponent {
        return appComponent.locationSubComponent().create()
    }

}