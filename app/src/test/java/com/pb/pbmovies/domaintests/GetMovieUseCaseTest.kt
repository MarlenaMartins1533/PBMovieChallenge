package com.pb.pbmovies.domaintests

import com.pb.pbmovies.Resources
import com.pb.pbmovies.data.repository.MovieRepository
import com.pb.pbmovies.domain.model.Movie
import com.pb.pbmovies.domain.usecase.GetMovieUseCase
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.RelaxedMockK
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test

class GetMovieUseCaseTest {

    @RelaxedMockK
    private lateinit var movieRepository: MovieRepository

    private lateinit var useCase: GetMovieUseCase

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        useCase = GetMovieUseCase(movieRepository)
    }

    // É possível padrões GWT de Cucumber para escrever testes, depende do padrão da PB.
    //`given GetMovieUseCase when MovieRepository is invoked then returns success`

    @Test
    fun `fetch movies returns success`() = runBlocking {
        var movieList: List<Movie> = emptyList()

        coEvery {
            movieRepository.fetchMovies()
        } returns Resources.dummyMovie

        movieList = useCase.invoke()
        assert(movieList.isNotEmpty())
    }

    @Test
    fun `fetch movies returns error`() = runBlocking {
        // TO..DO Futuro
    }
}