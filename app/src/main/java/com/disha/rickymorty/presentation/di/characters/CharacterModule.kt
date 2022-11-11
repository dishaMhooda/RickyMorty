package com.disha.rickymorty.presentation.di.characters

import com.disha.rickymorty.domain.usecase.GetCharactersUseCase
import com.disha.rickymorty.domain.usecase.UpdateCharactersUseCase
import com.disha.rickymorty.presentation.characters.CharacterViewModelFactory
import dagger.Module
import dagger.Provides


@Module
class CharacterModule {
    @CharacterScope
    @Provides
    fun provideCharactersViewModelFactory(
        getCharactersUseCase: GetCharactersUseCase,
        updateCharactersUseCase: UpdateCharactersUseCase
    ): CharacterViewModelFactory {
        return CharacterViewModelFactory(
            getCharactersUseCase,
            updateCharactersUseCase
        )
    }

}
