package com.example.movieapplication.model.localRoom

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import java.security.AccessControlContext

@Database(entities = [MovieEntity::class], version = 1)
abstract class MovieDataBase : RoomDatabase(){
    //DAO
    abstract fun moviesDao(): MoviesDao

    companion object{
        @Volatile
        private var INSTANCE : MovieDataBase? = null

        fun getDataBase(context: Context): MovieDataBase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this){
                val instance = Room.databaseBuilder(context,
                    MovieDataBase::class.java,
                    "moviesDataBase")
                    .build()
                INSTANCE = instance
                return instance
            }
        }
    }
}