package com.disha.rickymorty.domain.usecase

import com.disha.rickymorty.data.model.episode.Episodes
import com.disha.rickymorty.domain.repository.EpisodesRepository

class GetEpisodeUseCase(private val episodesRepository: EpisodesRepository) {

    suspend fun execute():Episodes?= episodesRepository.getEpisodes()
}