package com.lingga.testmoviedb.ui.nowplaying

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.lingga.testmoviedb.core.domain.model.Movie
import com.lingga.testmoviedb.core.domain.usecase.MovieUseCase
import com.lingga.testmoviedb.ui.base.BaseViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

class MovieNowPlayingViewModel(private val useCase: MovieUseCase) : BaseViewModel() {

    private val _movie = MutableLiveData<List<Movie>>()
    val movie: LiveData<List<Movie>> get() = _movie

    init {
        getMovieNowPlaying()
    }

    private fun getMovieNowPlaying() {
        viewModelScope.launch {
            useCase.getMovieNowPlaying().onStart {
                setLoading()
            }
                .collect {
                    _movie.postValue(it)
                    finishLoading()
                }
        }
    }
}