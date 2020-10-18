package com.example.movieapplication.viewModel

import androidx.lifecycle.AndroidViewModel
import com.example.movieapplication.model.MoviesRepository

class MovieViewModel :AndroidViewModel() {
    private val mRepository: MoviesRepository

    init {
        mRepository = MoviesRepository()
    }


}