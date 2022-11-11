package com.disha.rickymorty

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.room.RoomDatabase
import com.disha.rickymorty.data.db.dao.RickyDataBase
import com.disha.rickymorty.databinding.ActivityMainBinding
import com.disha.rickymorty.presentation.characters.CharacterActivity
import com.disha.rickymorty.presentation.episodes.EpisodesActivity
import com.disha.rickymorty.presentation.locations.LocationsActivity

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main)

        binding.characterButton.setOnClickListener {
            val intent = Intent(this, CharacterActivity::class.java)
            startActivity(intent)
        }
        binding.episodesButton.setOnClickListener {
            val intent = Intent(this, EpisodesActivity::class.java)
            startActivity(intent)
        }

        binding.locationsButton.setOnClickListener {
            val intent = Intent(this, LocationsActivity::class.java)
            startActivity(intent)
        }
    }
}
