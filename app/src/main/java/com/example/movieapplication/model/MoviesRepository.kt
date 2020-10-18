package com.example.movieapplication.model

import android.util.Log
import com.example.movieapplication.model.network.RetrofitClient
import com.example.movieapplication.model.pojos.Movie
import retrofit2.Call
import retrofit2.Response

class MoviesRepository {
    // Union de la API con el cliente Retrofit
    private val retroService = RetrofitClient.getRetrofitClient()

    fun getDataFromServer() {
        val call = retroService.allPopularMovies()
        call.enqueue(object : retrofit2.Callback<List<Movie>>{
            override fun onResponse(
                call: Call<List<Movie>>,
                response: Response<List<Movie>>
            ) {
                when(response.code()) {
                    in 200..299 -> Log.d("Response", response.body().toString())
                    in 300..399 -> Log.d("Response", response.errorBody().toString())
                    else -> Log.d("Error!", response.errorBody().toString())
                }
            }

            override fun onFailure(call: Call<List<Movie>>, t: Throwable) {
                Log.e("Error!", t.message.toString())
            }
        })
    }
}