package com.lingga.testmoviedb.utils

import com.lingga.testmoviedb.core.data.source.local.entity.MovieEntity
import com.lingga.testmoviedb.core.data.source.remote.response.MovieResponse
import com.lingga.testmoviedb.core.data.source.remote.response.ReviewResponse
import com.lingga.testmoviedb.core.domain.model.Movie
import com.lingga.testmoviedb.core.domain.model.Review

object DataMapper {

    fun responseToDomainMovies(input: List<MovieResponse>): List<Movie> {
        val movies = ArrayList<Movie>()
        input.map {
            val movie = Movie(
                id = it.id,
                title = it.title,
                overview = it.overview,
                isFavorite = false,
                posterPath = it.posterPath,
                releaseDate = it.releaseDate
            )
            movies.add(movie)
        }
        return movies
    }

    fun responseToDomainMovie(input: MovieResponse) = Movie(
        id = input.id,
        title = input.title,
        overview = input.overview,
        isFavorite = false,
        posterPath = input.posterPath,
        releaseDate = input.releaseDate
    )

    fun responseToDomainReviews(input: List<ReviewResponse>): List<Review> {
        val reviews = ArrayList<Review>()
        input.map {
            val review = Review(
                author = it.author,
                content = it.content,
                id = it.id,
                authorDetail = it.authorDetail
            )
            reviews.add(review)
        }
        return reviews
    }

    fun domainToEntityMovie(input: Movie) = MovieEntity(
        id = input.id,
        title = input.title,
        overview = input.overview,
        isFavorite = input.isFavorite,
        posterPath = input.posterPath,
        releaseDate = input.releaseDate
    )

    fun entityToDomainMovie(input: MovieEntity?) = Movie(
        id = input?.id ?: 0,
        title = input?.title,
        overview = input?.overview,
        isFavorite = input?.isFavorite ?: false,
        posterPath = input?.posterPath,
        releaseDate = input?.releaseDate
    )

    fun entitiesToDomainMovies(input: List<MovieEntity>) : List<Movie>{
        val movies = ArrayList<Movie>()
        input.map {
            val movie = Movie(
                id = it.id,
                title = it.title,
                overview = it.overview,
                isFavorite = false,
                posterPath = it.posterPath,
                releaseDate = it.releaseDate
            )
            movies.add(movie)
        }
        return movies
    }
}