package com.example.movieapplication.model.localRoom

import androidx.annotation.NonNull
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.movieapplication.model.pojos.Movie

@Entity(tableName = "popular_movies_table")
data class MoviePopularEntity(@PrimaryKey @NonNull val page: Int,
                       val totalResults: Int,
                       val totalPages: Int,
                       val results: List<Movie>
)