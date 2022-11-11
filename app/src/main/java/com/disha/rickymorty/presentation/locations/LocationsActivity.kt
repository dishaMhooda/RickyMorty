package com.disha.rickymorty.presentation.locations

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.disha.rickymorty.R
import com.disha.rickymorty.databinding.ActivityLocationsBinding
import com.disha.rickymorty.presentation.di.Injector

import javax.inject.Inject

class LocationsActivity: AppCompatActivity() {
    @Inject
    lateinit var factory: LocationViewModelFactory
    private lateinit var locationsViewModel: LocationViewModel
    private lateinit var binding: ActivityLocationsBinding
    private lateinit var adapter: LocationsAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_locations)
        (application as Injector).createLocationSubComponent()
            .inject(this)

        locationsViewModel = ViewModelProvider(this, factory)
            .get(LocationViewModel::class.java)
        initRecyclerView()

    }

    private fun initRecyclerView() {
        binding.locationsRecyclerView.layoutManager = LinearLayoutManager(this)
        adapter = LocationsAdapter()
        binding.locationsRecyclerView.adapter = adapter
        displayCharacters()
    }

    private fun displayCharacters() {
        binding.locationsProgressBar.visibility = View.VISIBLE
        val responseLiveData = locationsViewModel.getLocation()
        responseLiveData.observe(this, Observer {
            if (it != null) {
                adapter.setList(it.results)
                adapter.notifyDataSetChanged()
                binding.locationsProgressBar.visibility = View.GONE
            } else {
                binding.locationsProgressBar.visibility = View.GONE
                Toast.makeText(applicationContext, "No data available", Toast.LENGTH_LONG).show()
            }
        })
    }
}