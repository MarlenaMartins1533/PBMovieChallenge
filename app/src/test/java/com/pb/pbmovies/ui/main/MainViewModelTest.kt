package com.pb.pbmovies.ui.main

import com.pb.pbmovies.Resources
import com.pb.pbmovies.domain.usecase.GetMovieUseCase
import com.pb.pbmovies.ui.composable.mapper.MovieToItemMovieMapper
import io.mockk.coEvery
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.resetMain
import kotlinx.coroutines.test.runTest
import kotlinx.coroutines.test.setMain
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class MainViewModelTest {

    private val useCase: GetMovieUseCase = mockk()
    private val mapper: MovieToItemMovieMapper = mockk()
    private val mainViewModel: MainViewModel = MainViewModel(useCase, mapper)

    @Before
    fun setUp() {
        Dispatchers.setMain(UnconfinedTestDispatcher())
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun `fetchMovies returns success and the state change`() = runTest {
        //given
        val itemMovieListExpected = Resources.dummyItemMovie
        coEvery { useCase.invoke() } returns Resources.dummyMovie
        every { mapper.invoke(Resources.dummyMovie) } returns itemMovieListExpected

        //when
        mainViewModel.fetchMovies()

        //then
        assertEquals(itemMovieListExpected, mainViewModel.moviesData.value)
    }

    @Test
    fun `fetch movies returns error`() = runTest {
        // TO..DO Futuro
    }
}