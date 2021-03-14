package com.lingga.testmoviedb.ui.toprated

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.lingga.testmoviedb.core.domain.usecase.MovieUseCase
import com.lingga.testmoviedb.utils.FakeDataDummy
import com.lingga.testmoviedb.utils.FakeTestUseCase
import com.lingga.testmoviedb.utils.MainCoroutineRule
import com.lingga.testmoviedb.utils.getOrAwaitValue
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.hamcrest.CoreMatchers
import org.hamcrest.MatcherAssert
import org.junit.Before
import org.junit.Rule
import org.junit.Test

@ExperimentalCoroutinesApi
class TopRatedViewModelTest {

    @get:Rule
    val instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var topRatedViewModel: MovieTopRatedViewModel

    private lateinit var useCase: MovieUseCase

    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()

    @Before
    fun setUp() {
        useCase = FakeTestUseCase()
        topRatedViewModel = MovieTopRatedViewModel(useCase)
    }

    @Test
    fun getMovieTopRated() {
        runBlocking {
            useCase.getMovieTopRated()

            MatcherAssert.assertThat(
                topRatedViewModel.movie.getOrAwaitValue(),
                CoreMatchers.`is`(FakeDataDummy.generateDummyMovies())

            )
        }
    }
}