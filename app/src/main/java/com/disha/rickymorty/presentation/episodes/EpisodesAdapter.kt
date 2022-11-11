package com.disha.rickymorty.presentation.episodes

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView

import com.bumptech.glide.Glide
import com.disha.rickymorty.R
import com.disha.rickymorty.data.model.character.Characters
import com.disha.rickymorty.data.model.character.CharactersList
import com.disha.rickymorty.data.model.episode.EpisodesList
import com.disha.rickymorty.databinding.ListItemBinding

class EpisodesAdapter(): RecyclerView.Adapter<EpisodesViewHolder>() {
    private var episodesList = listOf<EpisodesList>()

    fun setList(episodesList: List<EpisodesList>){
        this.episodesList = episodesList;
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): EpisodesViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding : ListItemBinding = DataBindingUtil.inflate(
            layoutInflater,
            R.layout.list_item,
            parent,
            false
        )
        return EpisodesViewHolder(binding)
    }
    override fun getItemCount(): Int {
        Log.i("CHARACTER",episodesList.size.toString())
        return episodesList.size
    }
    override fun onBindViewHolder(holder: EpisodesViewHolder, position: Int) {
        holder.bind(episodesList[position])
    }
}

class EpisodesViewHolder(val binding : ListItemBinding): RecyclerView.ViewHolder(binding.root){
    fun bind(episodesList: EpisodesList){
        binding.titleTextView.text = episodesList.name
        binding.descriptionTextView.text = episodesList.airDate
        binding.createdTextView.text = episodesList.episode
        val posterURL = episodesList.url
        Log.i("posterURL",posterURL)
        Glide.with(binding.imageView.context)
            .load(posterURL)
            .into(binding.imageView)

    }

}