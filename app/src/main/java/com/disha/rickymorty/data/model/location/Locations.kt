package com.disha.rickymorty.data.model.location


import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.disha.rickymorty.util.Converters
import com.google.gson.annotations.SerializedName

@Entity(tableName = "locations")
@TypeConverters(Converters::class)
data class Locations(
    @PrimaryKey(autoGenerate = true)
    val id : Long,

    @SerializedName("info")
    val info: Info,
    @SerializedName("results")
    val results: List<LocationsList>
)