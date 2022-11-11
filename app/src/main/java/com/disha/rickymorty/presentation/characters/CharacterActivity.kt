package com.disha.rickymorty.presentation.characters

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.disha.rickymorty.R
import com.disha.rickymorty.databinding.ActivityCharacterBinding
import com.disha.rickymorty.presentation.di.Injector
import javax.inject.Inject


class CharacterActivity  : AppCompatActivity(){
    @Inject
    lateinit var factory: CharacterViewModelFactory
    private lateinit var characterViewModel: CharacterViewModel
    private lateinit var binding: ActivityCharacterBinding
    private lateinit var adapter: CharacterAdapter
    private var currentPage : Int = 1
    private var nextPage : Int = 0;
    private var totalCount : Int = 0
    private var prevPage : Int = 0
    private var totalPage : Int = Int.MAX_VALUE

    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_character)

            (application as Injector).createCharacterSubComponent()
                .inject(this)

        characterViewModel= ViewModelProvider(this,factory)
            .get(CharacterViewModel::class.java)

        val responseLiveData = characterViewModel.getCharacters()
        responseLiveData.observe(this, Observer {
            Log.i("MYTAG", it?.info?.next.toString())
            if((it!!.info.next != null) && it!!.info.next.trim().isNotEmpty()) {
                nextPage = Integer.valueOf(it!!.info.next.split("=")[1])
            }
            if((it!!.info.prev != null) && it!!.info.prev.toString().trim().isNotEmpty()){
                prevPage = Integer.valueOf(it!!.info.prev.toString().split("=")[1])
           }
            totalPage = Integer.valueOf(it!!.info.pages)
            totalCount = Integer.valueOf(it!!.info.count)
        })
        initRecyclerView()

    }

    private fun initRecyclerView() {
        binding.characterRecyclerView.layoutManager = LinearLayoutManager(this)
        adapter = CharacterAdapter()
        binding.characterRecyclerView.adapter = adapter
        displayCharacters()
    }
    private fun displayCharacters() {
        binding.characterProgressBar.visibility = View.VISIBLE
        val responseLiveData = characterViewModel.getCharacters()
        responseLiveData.observe(this, Observer {
            if (it != null) {
                adapter.setList(it.results)
                adapter.notifyDataSetChanged()
                binding.characterProgressBar.visibility = View.GONE
            } else {
                binding.characterRecyclerView.visibility = View.GONE
                Toast.makeText(applicationContext, "No data available", Toast.LENGTH_LONG).show()
            }
        })
    }
}