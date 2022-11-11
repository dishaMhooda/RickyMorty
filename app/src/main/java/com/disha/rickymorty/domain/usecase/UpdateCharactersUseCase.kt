package com.disha.rickymorty.domain.usecase

import com.disha.rickymorty.data.model.character.Characters
import com.disha.rickymorty.domain.repository.CharactersRepository

class UpdateCharactersUseCase (private val charactersRepository: CharactersRepository) {

    suspend fun execute():Characters ? = charactersRepository.updateCharacters()
}