package com.disha.rickymorty.presentation.di.core

import com.disha.rickymorty.data.api.RockyMortyService
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class NetModule(private val baseUrl: String) {

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(baseUrl)
            .build()
    }

    @Singleton
    @Provides
    fun provideRockyMortyService(retrofit: Retrofit): RockyMortyService {
        return retrofit.create(RockyMortyService::class.java)
    }

}