package com.lingga.testmoviedb.core.data

import com.lingga.testmoviedb.core.data.source.local.LocalDataSource
import com.lingga.testmoviedb.core.data.source.remote.RemoteDataSource
import com.lingga.testmoviedb.core.domain.model.Movie
import com.lingga.testmoviedb.core.domain.model.Review
import com.lingga.testmoviedb.core.domain.repository.IMovieRepository
import com.lingga.testmoviedb.utils.AppExecutors
import com.lingga.testmoviedb.utils.DataMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class MovieRepository(
    private val localDataSource: LocalDataSource,
    private val remoteDataSource: RemoteDataSource,
    private val appExecutors: AppExecutors
) : IMovieRepository {

    override suspend fun getMoviePopular(): Flow<List<Movie>> =
        remoteDataSource.fetchPopularMovie().map {
            DataMapper.responseToDomainMovies(it)
        }

    override suspend fun getMovieUpcoming(): Flow<List<Movie>> =
        remoteDataSource.fetchUpcomingMovie().map {
            DataMapper.responseToDomainMovies(it)
        }

    override suspend fun getMovieTopRated(): Flow<List<Movie>> =
        remoteDataSource.fetchTopRatedMovie().map {
            DataMapper.responseToDomainMovies(it)
        }

    override suspend fun getMovieNowPlaying(): Flow<List<Movie>> =
        remoteDataSource.fetchNowPlayingMovie().map {
            DataMapper.responseToDomainMovies(it)
        }

    override suspend fun getDetailMovie(id: Int): Flow<Movie> =
        remoteDataSource.fetchDetailMovie(id).map {
            DataMapper.responseToDomainMovie(it)
        }

    override suspend fun getReviewMovie(id: Int): Flow<List<Review>> =
        remoteDataSource.fetchReviewMovie(id).map {
            DataMapper.responseToDomainReviews(it)
        }

    override fun setFavoriteMovie(movie: Movie, state: Boolean) {
        val data = DataMapper.domainToEntityMovie(movie)
        appExecutors.diskIO().execute { localDataSource.setFavoriteMovie(data, state) }
    }

    override suspend fun getMovie(id: Int): Flow<Movie> =
        localDataSource.getMovie(id).map {
            DataMapper.entityToDomainMovie(it)
        }

    override suspend fun getFavoriteMovies(): Flow<List<Movie>> =
        localDataSource.getFavoriteMovies().map {
            DataMapper.entitiesToDomainMovies(it)
        }
}