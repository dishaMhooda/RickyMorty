package com.disha.rickymorty.presentation.characters

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

class CharacterAdapter(): RecyclerView.Adapter<CharacterViewHolder>() {
    private var charactersList = listOf<CharactersList>()

    fun setList(charactersList: List<CharactersList>){
        this.charactersList = charactersList;
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CharacterViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding : ListItemBinding = DataBindingUtil.inflate(
            layoutInflater,
            R.layout.list_item,
            parent,
            false
        )
        return CharacterViewHolder(binding)
    }
    override fun getItemCount(): Int {
        Log.i("CHARACTER",charactersList.size.toString())
        return charactersList.size
    }
    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        holder.bind(charactersList[position])
    }
}

class CharacterViewHolder(val binding : ListItemBinding): RecyclerView.ViewHolder(binding.root){
    fun bind(charactersList: CharactersList){
        binding.titleTextView.text = charactersList.name
        binding.descriptionTextView.text = charactersList.species
        binding.createdTextView.text = charactersList.created
        val posterURL = charactersList.image
        Log.i("posterURL",posterURL)
        Glide.with(binding.imageView.context)
            .load(posterURL)
            .into(binding.imageView)

    }

}