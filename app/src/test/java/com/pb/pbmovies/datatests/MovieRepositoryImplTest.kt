package com.pb.pbmovies.datatests

import com.pb.pbmovies.Resources
import com.pb.pbmovies.data.remote.datasource.IMovieRemoteDataSource
import com.pb.pbmovies.data.repository.MovieRepository
import com.pb.pbmovies.domain.model.Movie
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.runBlocking
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test


class MovieRepositoryImplTest {
    private lateinit var movieRepository: MovieRepository

    @RelaxedMockK
    private lateinit var apiService: IMovieRemoteDataSource

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        movieRepository = MovieRepository(apiService)
    }

    @Test
    fun `get movies from api returns success`() = runBlocking {
        var movieList: List<Movie> = emptyList()

        coEvery {
            apiService.fetchMovies()
        } returns Resources.dummyMovie

        movieList = movieRepository.fetchMovies()

        assertEquals(movieList.size, Resources.dummyMovie.size)
        assertEquals(movieList.first().title, Resources.dummyMovie.first().title)
    }

    @Test
    fun `get movies from api returns error`() = runBlocking {
        // TO..DO Futuro
//        var movieList: List<Movie> = emptyList()
//
//        coEvery {
//            apiService.fetchMovies()
//        } returns Throwable("Error") // TO..DO Futuro
//
//        movieList = movieRepository.fetchMovies()
//
//        assertNotEquals(movieList.size, Resources.movieResponse.size)
//        assertNotEquals(movieList.first().title, Resources.movieResponse.first().title)
    }
}