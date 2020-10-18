package com.example.movieapplication.model.network

import com.example.movieapplication.model.pojos.Movie
import com.example.movieapplication.model.pojos.MovieList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieAPI {
    // Mostrar todas las peliculas populares
    @GET("/3/movie/popular?api_key=b1f126157f537273ff8cd8b94da6313a")
    fun allPopularMovies(): Call<MovieList>

    // Mostrar una sola pelicula
    @GET("/3/movie/{id}?api_key=b1f126157f537273ff8cd8b94da6313a")
    fun details(@Path("id") detailsId: Int): Call<List<Movie>>

    // Buscar peliculas
    @GET("/3/search/movie?api_key=b1f126157f537273ff8cd8b94da6313a&language=en-US&page=1&include_adult=false")
    fun search(@Query("query") searchName: String?): Call<MovieList>

    // CORRUTINAS

    // Mostrar todas las peliculas populares
    @GET("/3/movie/popular?api_key=b1f126157f537273ff8cd8b94da6313a")
    fun allPopularMoviesWithCoroutines(): Call<MovieList>

    // Mostrar una sola pelicula
    @GET("/3/movie/{id}?api_key=b1f126157f537273ff8cd8b94da6313a")
    fun detailsWithCoroutines(@Path("id") detailsId: Int): Call<List<Movie>>

    // Buscar peliculas
    @GET("/3/search/movie?api_key=b1f126157f537273ff8cd8b94da6313a&language=en-US&page=1&include_adult=false")
    fun searchWithCoroutines(@Query("query") searchName: String?): Call<MovieList>
}