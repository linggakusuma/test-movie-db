package com.lingga.testmoviedb.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.lingga.testmoviedb.core.domain.model.Movie
import com.lingga.testmoviedb.core.domain.model.Review
import com.lingga.testmoviedb.core.domain.usecase.MovieUseCase
import com.lingga.testmoviedb.ui.base.BaseViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class MovieDetailViewModel(private val useCase: MovieUseCase) : BaseViewModel() {

    private val _movie = MutableLiveData<Movie>()
    val movie: LiveData<Movie> get() = _movie

    private val _reviews = MutableLiveData<List<Review>>()
    val reviews: LiveData<List<Review>> get() = _reviews

    private val _movieFavorite = MutableLiveData<Movie>()
    val movieFavorite: LiveData<Movie> get() = _movieFavorite


    fun getDetailMovie(id: Int) {
        viewModelScope.launch {
            useCase.getDetailMovie(id)
                .collect {
                    _movie.postValue(it)
                }
        }
    }

    fun getReviews(id: Int) {
        viewModelScope.launch {
            useCase.getReviewMovie(id).collect {
                _reviews.postValue(it)
            }
        }
    }

    fun getMovieFavorite(id: Int) {
        viewModelScope.launch {
            useCase.getMovie(id).collect {
                _movieFavorite.postValue(it)
            }
        }
    }

    fun setFavoriteMovie(movie: Movie, state: Boolean) = useCase.setFavoriteMovie(movie, state)
}