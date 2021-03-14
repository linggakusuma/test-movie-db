package com.lingga.testmoviedb.core.domain.usecase

import com.lingga.testmoviedb.core.domain.model.Movie
import com.lingga.testmoviedb.core.domain.model.Review
import com.lingga.testmoviedb.core.domain.repository.IMovieRepository
import kotlinx.coroutines.flow.Flow

class MovieInteractor(private val iMovieRepository: IMovieRepository) : MovieUseCase {

    override suspend fun getMoviePopular(): Flow<List<Movie>> = iMovieRepository.getMoviePopular()

    override suspend fun getMovieUpcoming(): Flow<List<Movie>> = iMovieRepository.getMovieUpcoming()

    override suspend fun getMovieTopRated(): Flow<List<Movie>> = iMovieRepository.getMovieTopRated()

    override suspend fun getMovieNowPlaying(): Flow<List<Movie>> =
        iMovieRepository.getMovieNowPlaying()

    override suspend fun getDetailMovie(id: Int): Flow<Movie> = iMovieRepository.getDetailMovie(id)

    override suspend fun getReviewMovie(id: Int): Flow<List<Review>> =
        iMovieRepository.getReviewMovie(id)

    override fun setFavoriteMovie(movie: Movie, state: Boolean) =
        iMovieRepository.setFavoriteMovie(movie, state)

    override suspend fun getMovie(id: Int): Flow<Movie> = iMovieRepository.getMovie(id)

    override suspend fun getFavoriteMovies(): Flow<List<Movie>> = iMovieRepository.getFavoriteMovies()
}