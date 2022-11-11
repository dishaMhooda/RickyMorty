package com.disha.rickymorty.presentation.episodes

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.disha.rickymorty.data.model.character.CharactersList
import com.disha.rickymorty.data.model.episode.EpisodesList

import com.disha.rickymorty.domain.usecase.GetEpisodeUseCase
import com.disha.rickymorty.domain.usecase.UpdateCharactersUseCase
import com.disha.rickymorty.domain.usecase.UpdateEpisodeUseCase


class EpisodesViewModel(
    private val getEpisodeUseCase: GetEpisodeUseCase,
    private val updateEpisodeUseCase: UpdateEpisodeUseCase
): ViewModel() {

    fun getEpisodes() = liveData {
        val episodesList = getEpisodeUseCase.execute()
        emit(episodesList)
    }

    fun updateEpisodes() = liveData {
        val episodesList = updateEpisodeUseCase.execute()
        emit(episodesList)
    }

}
