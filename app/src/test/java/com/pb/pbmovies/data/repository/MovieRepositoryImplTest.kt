package com.pb.pbmovies.data.repository

import com.pb.pbmovies.Resources
import com.pb.pbmovies.data.remote.datasource.IMovieRemoteDataSource
import com.pb.pbmovies.domain.repository.IMovieRepository
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Test

class MovieRepositoryImplTest {

    private val apiService: IMovieRemoteDataSource = mockk()
    private val movieRepository: IMovieRepository = MovieRepository(apiService)

    @Test
    fun `get movies from api returns success`() = runBlocking {
        //given
        coEvery { apiService.fetchMovies() } returns Resources.dummyMovie

        //when
        val movieList = movieRepository.fetchMovies()

        //then
        assertEquals(movieList.size, Resources.dummyMovie.size)
        assertEquals(movieList.first().title, Resources.dummyMovie.first().title)
    }

    @Test
    fun `get movies from api returns error`() = runBlocking {
        // TO..DO
    }
}