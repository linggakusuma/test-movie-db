package com.lingga.testmoviedb.utils

import com.lingga.testmoviedb.core.domain.model.Movie
import com.lingga.testmoviedb.core.domain.model.Review
import com.lingga.testmoviedb.core.domain.usecase.MovieUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class FakeTestUseCase : MovieUseCase {

    private val movies = FakeDataDummy.generateDummyMovies()

    private val reviews = FakeDataDummy.generateDummyReviews(527774)

    override suspend fun getMoviePopular(): Flow<List<Movie>> {
        return flow {
            try {
                emit(movies)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    override suspend fun getMovieUpcoming(): Flow<List<Movie>> {
        return flow {
            try {
                emit(movies)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    override suspend fun getMovieTopRated(): Flow<List<Movie>> {
        return flow {
            try {
                emit(movies)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    override suspend fun getMovieNowPlaying(): Flow<List<Movie>> {
        return flow {
            try {
                emit(movies)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    override suspend fun getDetailMovie(id: Int): Flow<Movie> {
        return flow {
            try {
                emit(FakeDataDummy.generateDummyMovie())
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    override suspend fun getReviewMovie(id: Int): Flow<List<Review>> {
        return flow {
            try {
                emit(reviews)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    override fun setFavoriteMovie(movie: Movie, state: Boolean) {}

    override suspend fun getMovie(id: Int): Flow<Movie> {
        return flow {
            try {
                emit(FakeDataDummy.generateDummyMovie())
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

    override suspend fun getFavoriteMovies(): Flow<List<Movie>> {
        return flow {
            try {
                emit(movies)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}