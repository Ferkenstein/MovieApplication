package com.example.movieapplication.model.localRoom

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface MoviesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllPopularMovies( mList: List<MovieEntity>)

    @Query("SELECT * FROM movies_table")
    fun showAllPopularMovies(): LiveData<List<MovieEntity>>

    @Query("SELECT * FROM movies_table WHERE id =:mId" )
    fun showOnMoviesById(mId : Int): LiveData<MovieEntity>


}