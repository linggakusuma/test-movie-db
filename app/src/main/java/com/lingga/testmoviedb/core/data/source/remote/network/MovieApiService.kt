package com.lingga.testmoviedb.core.data.source.remote.network

import com.lingga.testmoviedb.BuildConfig
import com.lingga.testmoviedb.core.data.source.remote.response.BaseMovieResponse
import com.lingga.testmoviedb.core.data.source.remote.response.MovieResponse
import com.lingga.testmoviedb.core.data.source.remote.response.ReviewResponse
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface MovieApiService {

    @GET("movie/popular")
    suspend fun getMoviePopular(@Query("api_key") apiKey: String? = BuildConfig.TMDB_API_KEY): BaseMovieResponse<MovieResponse>

    @GET("movie/upcoming")
    suspend fun getUpcomingMovie(@Query("api_key") apiKey: String? = BuildConfig.TMDB_API_KEY): BaseMovieResponse<MovieResponse>

    @GET("movie/top_rated")
    suspend fun getTopRatedMovie(@Query("api_key") apiKey: String? = BuildConfig.TMDB_API_KEY): BaseMovieResponse<MovieResponse>

    @GET("movie/now_playing")
    suspend fun getNowPlayingMovie(@Query("api_key") apiKey: String? = BuildConfig.TMDB_API_KEY): BaseMovieResponse<MovieResponse>

    @GET("movie/{movie_id}")
    suspend fun getDetailMovie(
        @Path("movie_id") movieId: Int,
        @Query("api_key") apiKey: String? = BuildConfig.TMDB_API_KEY
    ): MovieResponse

    @GET("movie/{movie_id}/reviews")
    suspend fun getReviewMovie(
        @Path("movie_id") movieId: Int,
        @Query("api_key") apiKey: String? = BuildConfig.TMDB_API_KEY
    ): BaseMovieResponse<ReviewResponse>
}