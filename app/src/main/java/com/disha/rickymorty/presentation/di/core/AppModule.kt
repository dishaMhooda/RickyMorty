package com.disha.rickymorty.presentation.di.core

import android.content.Context
import com.disha.rickymorty.presentation.di.characters.CharacterSubComponent
import com.disha.rickymorty.presentation.di.episodes.EpisodeSubComponent
import com.disha.rickymorty.presentation.di.locations.LocationSubComponent


import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module(subcomponents = [CharacterSubComponent::class , EpisodeSubComponent::class , LocationSubComponent::class])
class AppModule(private val context: Context) {

 @Singleton
 @Provides
 fun provideApplicationContext():Context{
     return context.applicationContext
 }





}