package com.disha.rickymorty.presentation.locations

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
import com.disha.rickymorty.data.model.location.LocationsList
import com.disha.rickymorty.databinding.ListItemBinding

class LocationsAdapter(): RecyclerView.Adapter<LocationsViewHolder>() {
    private var locationList = listOf<LocationsList>()

    fun setList(locationList: List<LocationsList>){
        this.locationList = locationList;
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LocationsViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding : ListItemBinding = DataBindingUtil.inflate(
            layoutInflater,
            R.layout.list_item,
            parent,
            false
        )
        return LocationsViewHolder(binding)
    }
    override fun getItemCount(): Int {
        Log.i("CHARACTER",locationList.size.toString())
        return locationList.size
    }
    override fun onBindViewHolder(holder: LocationsViewHolder, position: Int) {
        holder.bind(locationList[position])
    }
}

class LocationsViewHolder(val binding : ListItemBinding): RecyclerView.ViewHolder(binding.root){
    fun bind(locationList: LocationsList){
        binding.titleTextView.text = locationList.name
        binding.descriptionTextView.text = locationList.type
        binding.createdTextView.text = locationList.created
        val posterURL = locationList.url
        Log.i("posterURL",posterURL)
        Glide.with(binding.imageView.context)
            .load(posterURL)
            .into(binding.imageView)

    }

}