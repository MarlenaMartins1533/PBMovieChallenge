package com.pb.pbmovies.presentationtests

import com.pb.pbmovies.Resources
import com.pb.pbmovies.domain.model.Movie
import com.pb.pbmovies.domain.usecase.GetMovieUseCase
import com.pb.pbmovies.ui.viewmodel.MainViewModel
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.cancel
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import org.junit.Assert.assertEquals
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.StandardTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.assertNotEquals
import org.junit.Before
import org.junit.Test

class MainViewModelTest {
    private lateinit var mainViewModel: MainViewModel

    @RelaxedMockK
    private lateinit var useCase: GetMovieUseCase

    private val testDispatcher = StandardTestDispatcher()

    @OptIn(ExperimentalCoroutinesApi::class)
    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        Dispatchers.setMain(testDispatcher)
        mainViewModel = MainViewModel(useCase)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    // É possível outros padrões como GWT de Cucumber para escrever testes, depende do padrão adotado por vocês da PB.
    //`given ... when ... then ...`

    @Test
    fun `fetchMovies returns success and the state change`() = runTest {
        val movieListExpected = Resources.dummyMovie

        coEvery { useCase.invoke() } returns movieListExpected

        mainViewModel.fetchMovies()

        val job = launch {
            mainViewModel.moviesData.collect { emittedList ->
                assertEquals(movieListExpected, emittedList)
                cancel()
            }
        }

        job.join()
    }

    @Test
    fun `fetch movies returns error`() = runBlocking {
        // TO..DO Futuro
    }
}