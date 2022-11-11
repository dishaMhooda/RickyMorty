package com.disha.rickymorty.presentation.characters

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.disha.rickymorty.domain.usecase.GetCharactersUseCase
import com.disha.rickymorty.domain.usecase.UpdateCharactersUseCase


class CharacterViewModel(
    private val getCharactersUseCase: GetCharactersUseCase,
    private val updateCharactersUseCase: UpdateCharactersUseCase
): ViewModel() {



    fun getCharacters() = liveData {
        val charactersList = getCharactersUseCase.execute()
        emit(charactersList)
    }

    fun updateCharacters() = liveData {
        val charactersList = updateCharactersUseCase.execute()
        emit(charactersList)
    }

}
