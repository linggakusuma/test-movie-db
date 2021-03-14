package com.lingga.testmoviedb.core.domain.repository

import com.lingga.testmoviedb.core.domain.model.Movie
import com.lingga.testmoviedb.core.domain.model.Review
import kotlinx.coroutines.flow.Flow

interface IMovieRepository {
    suspend fun getMoviePopular(): Flow<List<Movie>>
    suspend fun getMovieUpcoming(): Flow<List<Movie>>
    suspend fun getMovieTopRated(): Flow<List<Movie>>
    suspend fun getMovieNowPlaying(): Flow<List<Movie>>
    suspend fun getDetailMovie(id: Int): Flow<Movie>
    suspend fun getReviewMovie(id: Int): Flow<List<Review>>
    fun setFavoriteMovie(movie: Movie, state: Boolean)
    suspend fun getMovie(id: Int): Flow<Movie>
    suspend fun getFavoriteMovies(): Flow<List<Movie>>
}