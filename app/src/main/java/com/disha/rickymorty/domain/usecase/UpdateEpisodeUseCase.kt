package com.disha.rickymorty.domain.usecase

import com.disha.rickymorty.data.model.episode.Episodes
import com.disha.rickymorty.domain.repository.EpisodesRepository

class UpdateEpisodeUseCase(private val episodesRepository: EpisodesRepository) {

    suspend fun execute():Episodes?= episodesRepository.updateEpisodes()
}