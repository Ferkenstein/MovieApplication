package com.example.movieapplication.model.localRoom

import androidx.annotation.NonNull
import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.movieapplication.model.pojos.SpokenLanguage

@Entity(tableName = "movies_table")
data class MovieEntity(@PrimaryKey @NonNull val id: Int,
                       val image: String,
                       val name: String,
                       val overview: String,
                       val popularity: Double,
                       @Embedded val spokenLanguages: List<String>,
)