package com.disha.rickymorty.presentation.episodes

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.disha.rickymorty.domain.usecase.GetEpisodeUseCase
import com.disha.rickymorty.domain.usecase.UpdateEpisodeUseCase


class EpisodesViewModelFactory (
    private val getEpisodeUseCase: GetEpisodeUseCase,
    private val updateEpisodeUseCase: UpdateEpisodeUseCase
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return EpisodesViewModel(getEpisodeUseCase,updateEpisodeUseCase) as T
    }
}
