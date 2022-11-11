package com.disha.rickymorty.presentation.episodes

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.disha.rickymorty.R
import com.disha.rickymorty.databinding.ActivityEpisodesBinding
import com.disha.rickymorty.presentation.di.Injector
import com.disha.rickymorty.presentation.characters.CharacterAdapter

import javax.inject.Inject

class EpisodesActivity : AppCompatActivity(){
    @Inject
    lateinit var factory: EpisodesViewModelFactory
    private lateinit var episodesViewModel: EpisodesViewModel
    private lateinit var binding: ActivityEpisodesBinding
    private lateinit var adapter: EpisodesAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_episodes)
        (application as Injector).createEpisodeSubComponent()
            .inject(this)

        episodesViewModel= ViewModelProvider(this,factory)
            .get(EpisodesViewModel::class.java)
        initRecyclerView()

    }

    private fun initRecyclerView() {
        binding.episodesRecyclerView.layoutManager = LinearLayoutManager(this)
        adapter = EpisodesAdapter()
        binding.episodesRecyclerView.adapter = adapter
        displayCharacters()
    }
    private fun displayCharacters() {
        binding.episodesProgressBar.visibility = View.VISIBLE
        val responseLiveData = episodesViewModel.getEpisodes()
        responseLiveData.observe(this, Observer {
            if (it != null) {
                adapter.setList(it.results)
                adapter.notifyDataSetChanged()
                binding.episodesProgressBar.visibility = View.GONE
            } else {
                binding.episodesProgressBar.visibility = View.GONE
                Toast.makeText(applicationContext, "No data available", Toast.LENGTH_LONG).show()
            }
        })
    }
}