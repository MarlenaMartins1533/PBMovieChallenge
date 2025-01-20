package com.pb.pbmovies.domain.usecase

import com.pb.pbmovies.Resources
import com.pb.pbmovies.domain.repository.IMovieRepository
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Test

class GetMovieUseCaseTest {

    private val movieRepository: IMovieRepository = mockk()
    private val useCase = GetMovieUseCase(movieRepository)

    @Test
    fun `given GetMovieUseCase when MovieRepository is invoked then returns success`() = runTest {
        //given
        coEvery { movieRepository.fetchMovies() } returns Resources.dummyMovie

        //when
        val movieList = useCase.invoke()

        //then
        assert(movieList.isNotEmpty())
    }

    @Test
    fun `fetch movies returns error`() = runTest {
        // TO..DO
    }
}