package com.lingga.testmoviedb.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.lingga.testmoviedb.core.domain.model.Movie
import com.lingga.testmoviedb.core.domain.usecase.MovieUseCase
import com.lingga.testmoviedb.ui.base.BaseViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

class HomeViewModel(private val useCase: MovieUseCase) : BaseViewModel() {

    private val _movie = MutableLiveData<List<Movie>>()
    val movie: LiveData<List<Movie>> get() = _movie

    init {
        getMoviePopular()
    }

    private fun getMoviePopular() {
        viewModelScope.launch {
            useCase.getMoviePopular().onStart {
                setLoading()
            }
                .collect {
                    _movie.postValue(it)
                    finishLoading()
                }
        }
    }
}