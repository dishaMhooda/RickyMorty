package com.disha.rickymorty.data.model.episode


import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.disha.rickymorty.util.Converters
import com.google.gson.annotations.SerializedName

@Entity(tableName = "episodes")
@TypeConverters(Converters::class)
data class Episodes(
    @PrimaryKey(autoGenerate = true)
    val id : Long,
    @SerializedName("info")

    val info: Info,
    @SerializedName("results")
    val results: List<EpisodesList>
)