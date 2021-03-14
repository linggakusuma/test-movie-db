package com.lingga.testmoviedb.ui.home

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.lingga.testmoviedb.core.domain.usecase.MovieUseCase
import com.lingga.testmoviedb.utils.FakeDataDummy
import com.lingga.testmoviedb.utils.FakeTestUseCase
import com.lingga.testmoviedb.utils.MainCoroutineRule
import com.lingga.testmoviedb.utils.getOrAwaitValue
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class HomeViewModelTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var homeViewModel: HomeViewModel

    private lateinit var useCase: MovieUseCase

    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()

    @Before
    fun setUp() {
        useCase = FakeTestUseCase()
        homeViewModel = HomeViewModel(useCase)
    }

    @Test
    fun getMoviePopular() {
        runBlocking {
            useCase.getMoviePopular()

            assertThat(
                homeViewModel.movie.getOrAwaitValue(),
                `is`(FakeDataDummy.generateDummyMovies())

            )
        }
    }

}