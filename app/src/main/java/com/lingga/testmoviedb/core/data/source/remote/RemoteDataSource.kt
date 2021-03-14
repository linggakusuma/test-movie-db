package com.lingga.testmoviedb.core.data.source.remote

import android.util.Log
import com.lingga.testmoviedb.core.data.source.remote.network.MovieApiService
import com.lingga.testmoviedb.core.data.source.remote.response.MovieResponse
import com.lingga.testmoviedb.core.data.source.remote.response.ReviewResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class RemoteDataSource(private val movieApiService: MovieApiService) {

    suspend fun fetchPopularMovie(): Flow<List<MovieResponse>> {
        return flow {
            try {
                val response = movieApiService.getMoviePopular()
                val data = response.results
                if (data.isNotEmpty()) {
                    emit(data)
                }
            } catch (e: Exception) {
                Log.e("RemoteDataSource", e.toString())
            }
        }.flowOn(Dispatchers.IO)
    }

    suspend fun fetchUpcomingMovie(): Flow<List<MovieResponse>> {
        return flow {
            try {
                val response = movieApiService.getUpcomingMovie()
                val data = response.results
                if (data.isNotEmpty()) {
                    emit(data)
                }
            } catch (e: Exception) {
                Log.e("RemoteDataSource", e.toString())
            }
        }.flowOn(Dispatchers.IO)
    }

    suspend fun fetchTopRatedMovie(): Flow<List<MovieResponse>> {
        return flow {
            try {
                val response = movieApiService.getTopRatedMovie()
                val data = response.results
                if (data.isNotEmpty()) {
                    emit(data)
                }
            } catch (e: Exception) {
                Log.e("RemoteDataSource", e.toString())
            }
        }.flowOn(Dispatchers.IO)
    }

    suspend fun fetchNowPlayingMovie(): Flow<List<MovieResponse>> {
        return flow {
            try {
                val response = movieApiService.getNowPlayingMovie()
                val data = response.results
                if (data.isNotEmpty()) {
                    emit(data)
                }
            } catch (e: Exception) {
                Log.e("RemoteDataSource", e.toString())
            }
        }.flowOn(Dispatchers.IO)
    }

    suspend fun fetchDetailMovie(id: Int): Flow<MovieResponse> {
        return flow {
            try {
                val data = movieApiService.getDetailMovie(id)
                emit(data)
            } catch (e: Exception) {
                Log.e("RemoteDataSource", e.toString())
            }
        }.flowOn(Dispatchers.IO)
    }

    suspend fun fetchReviewMovie(id: Int): Flow<List<ReviewResponse>> {
        return flow {
            try {
                val response = movieApiService.getReviewMovie(id)
                val data = response.results
                if (data.isNotEmpty()) {
                    emit(data)
                }
            } catch (e: Exception) {
                Log.e("RemoteDataSource", e.toString())
            }
        }.flowOn(Dispatchers.IO)
    }
}