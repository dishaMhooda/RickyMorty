package com.disha.rickymorty.data.model.character


import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.disha.rickymorty.util.Converters
import com.google.gson.annotations.SerializedName

@Entity(tableName = "characters")
@TypeConverters(Converters::class)
data class Characters(

    @PrimaryKey(autoGenerate = true)
    val id : Long,
    @SerializedName("info")
    val info: Info,
    @SerializedName("results")
    val results: List<CharactersList>
)