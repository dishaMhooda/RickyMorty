package com.disha.rickymorty.util

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.disha.rickymorty.data.model.character.CharactersList
import com.disha.rickymorty.data.model.character.Info
import com.disha.rickymorty.data.model.character.Location
import com.disha.rickymorty.data.model.episode.EpisodesList
import com.disha.rickymorty.data.model.location.LocationsList
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.lang.reflect.Type


@ProvidedTypeConverter
class Converters{
        @TypeConverter
        fun fromCharacters(h: Info?): String {
            val gson = Gson()
            return gson.toJson(h)
        }

        @TypeConverter
        fun toCharacters(s: String?): Info {
            return Gson().fromJson(s, Info::class.java)
        }

        @TypeConverter
        fun fromEpisodes(h: com.disha.rickymorty.data.model.episode.Info?): String {
            val gson = Gson()
            return gson.toJson(h)
    }

         @TypeConverter
         fun toEpisodes(s: String?): com.disha.rickymorty.data.model.episode.Info {
            return Gson().fromJson(s, com.disha.rickymorty.data.model.episode.Info::class.java)
        }

    @TypeConverter
    fun fromLocations(h: com.disha.rickymorty.data.model.location.Info?): String {
        val gson = Gson()
        return gson.toJson(h)
    }

    @TypeConverter
    fun toLocations(s: String?): com.disha.rickymorty.data.model.location.Info {
        return Gson().fromJson(s, com.disha.rickymorty.data.model.location.Info::class.java)
    }
    @TypeConverter
    fun toCharacterJson(charactersList: List<CharactersList>) : String {
        var gson = Gson()
        return gson.toJson(charactersList)
    }

    @TypeConverter
    fun fromCharacterJson(json: String): List<CharactersList>{
        val listType: Type = object : TypeToken<ArrayList<String?>?>() {}.type
        return Gson().fromJson(json, listType)
    }

    @TypeConverter
    fun toEpisodesJson(episodesList: List<EpisodesList>) : String {
        var gson = Gson()
        return gson.toJson(episodesList)
    }

    @TypeConverter
    fun fromEpisodesJson(json: String): List<EpisodesList>{
        val listType: Type = object : TypeToken<ArrayList<String?>?>() {}.type
        return Gson().fromJson(json, listType)
    }

    @TypeConverter
    fun toLocationsJson(locationList: List<LocationsList>) : String {
        var gson = Gson()
        return gson.toJson(locationList)
    }

    @TypeConverter
    fun fromLocationsJson(json: String): List<LocationsList>{
        val listType: Type = object : TypeToken<ArrayList<String?>?>() {}.type
        return Gson().fromJson(json, listType)
    }

    //List<String>
    @TypeConverter
    fun toCharacterListJson(character: List<String>) : String {
        var gson = Gson()
        return gson.toJson(character)
    }

    @TypeConverter
    fun fromCharacterListJson(json: String): List<String>{
        val listType: Type = object : TypeToken<ArrayList<String?>?>() {}.type
        return Gson().fromJson(json, listType)
    }


    // Location

    @TypeConverter
    fun fromCharactersLocation(h: Location?): String {
        val gson = Gson()
        return gson.toJson(h)
    }

    @TypeConverter
    fun toCharactersLocation(s: String?): Location {
        return Gson().fromJson(s, Location::class.java)
    }
}
