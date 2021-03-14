package com.lingga.testmoviedb.core.data.source.local

import com.lingga.testmoviedb.core.data.source.local.entity.MovieEntity
import com.lingga.testmoviedb.core.data.source.local.room.MovieDao
import kotlinx.coroutines.flow.Flow

class LocalDataSource(private val movieDao: MovieDao) {

    fun getFavoriteMovies(): Flow<List<MovieEntity>> = movieDao.getFavoriteMovies()

    fun setFavoriteMovie(movie: MovieEntity, state: Boolean) {
        movie.isFavorite = state
        movieDao.insertFavoriteMovie(movie)
    }

    fun getMovie(id:Int) = movieDao.getMovie(id)

}