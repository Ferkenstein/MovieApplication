package com.example.movieapplication.model.pojos

import com.google.gson.annotations.SerializedName

data class MovieList (
        var page:Int = 0,
        @SerializedName("total_results")
        var totalResults:Int = 0,
        @SerializedName("total_pages")
        var totalPages:Int = 0,
        @SerializedName("results")
        var results:List<Movie> = listOf<Movie>()
)
