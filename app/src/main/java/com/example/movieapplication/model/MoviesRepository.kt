package com.example.movieapplication.model

import android.util.Log
import com.example.movieapplication.model.localRoom.MovieEntity
import com.example.movieapplication.model.localRoom.MoviesDao
import com.example.movieapplication.model.network.RetrofitClient
import com.example.movieapplication.model.pojos.Movie
import com.example.movieapplication.model.pojos.MovieList
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Call
import retrofit2.Response

class MoviesRepository(private val moviesDao: MoviesDao) {

    // Union de la API con el cliente Retrofit
    private val retroService = RetrofitClient.getRetrofitClient()
    // Traer tabla de peliculas Entity
    val  allMoviesLiveData = moviesDao.showAllPopularMovies()

    fun getDataFromServer() {
        val call = retroService.allPopularMovies()
        call.enqueue(object : retrofit2.Callback<MovieList>{
            override fun onResponse(
                call: Call<MovieList>,
                response: Response<MovieList>
            ) {
                when(response.code()) {
                    in 200..299 -> CoroutineScope(Dispatchers.IO).launch {
                        Log.d("RESPONSEOK", response.body().toString())
                        response.body()?.let {
                            moviesDao.insertAllPopularMovies(convert(it))
                        }
                    }
                    in 300..399 -> Log.d("Response", response.errorBody().toString())
                    else -> Log.d("Error300!", response.errorBody().toString())
                }
            }

            override fun onFailure(call: Call<MovieList>, t: Throwable) {
                Log.e("Error!", t.message.toString())
            }
        })
    }

    // Transformar datos desde Internet hacia la Entidad
    fun convert(listFromNetwork: MovieList): List<MovieEntity> {
        val listMutable = mutableListOf<MovieEntity>()

        listFromNetwork.results.map {
            listMutable.add( MovieEntity(it.id,
                it.posterPath,
                it.originalTitle,
                it.overview,
                it.popularity) )
        }
        return listMutable
    }
}