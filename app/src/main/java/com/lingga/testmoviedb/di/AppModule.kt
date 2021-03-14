package com.lingga.testmoviedb.di

import com.lingga.testmoviedb.core.domain.usecase.MovieInteractor
import com.lingga.testmoviedb.core.domain.usecase.MovieUseCase
import com.lingga.testmoviedb.ui.detail.MovieDetailViewModel
import com.lingga.testmoviedb.ui.favorite.FavoriteViewModel
import com.lingga.testmoviedb.ui.home.HomeViewModel
import com.lingga.testmoviedb.ui.nowplaying.MovieNowPlayingViewModel
import com.lingga.testmoviedb.ui.toprated.MovieTopRatedViewModel
import com.lingga.testmoviedb.ui.upcoming.UpcomingViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

val useCaseModule = module {
    factory<MovieUseCase> { MovieInteractor(get()) }
}

val viewModelModule = module {
    viewModel { HomeViewModel(get()) }
    viewModel { UpcomingViewModel(get()) }
    viewModel { MovieTopRatedViewModel(get()) }
    viewModel { MovieNowPlayingViewModel(get()) }
    viewModel { MovieDetailViewModel(get()) }
    viewModel { FavoriteViewModel(get()) }
}