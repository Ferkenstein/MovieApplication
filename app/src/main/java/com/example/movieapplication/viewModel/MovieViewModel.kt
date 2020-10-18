package com.example.movieapplication.viewModel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.example.movieapplication.model.MoviesRepository
import com.example.movieapplication.model.localRoom.MovieDataBase
import com.example.movieapplication.model.localRoom.MovieEntity

class MovieViewModel(application: Application) : AndroidViewModel(application) {

    private val mRepository: MoviesRepository
    val liveDataFromLocal : LiveData<List<MovieEntity>>

    init {
        val moviesDao = MovieDataBase.getDataBase(application).moviesDao()
        mRepository = MoviesRepository(moviesDao)
        mRepository.getDataFromServer()
        liveDataFromLocal = mRepository.allMoviesLiveData
    }


}