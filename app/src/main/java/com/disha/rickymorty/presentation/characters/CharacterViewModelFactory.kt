package com.disha.rickymorty.presentation.characters

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.disha.rickymorty.domain.usecase.GetCharactersUseCase
import com.disha.rickymorty.domain.usecase.UpdateCharactersUseCase

class CharacterViewModelFactory (
    private val getCharactersUseCase: GetCharactersUseCase,
    private val updateCharactersUseCase: UpdateCharactersUseCase
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return CharacterViewModel(getCharactersUseCase,updateCharactersUseCase) as T
    }
}
