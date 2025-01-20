package com.pb.pbmovies.domain.usecase

import com.pb.pbmovies.data.repository.MovieRepository
import com.pb.pbmovies.domain.model.Movie
import com.pb.pbmovies.domain.repository.IMovieRepository

class GetMovieUseCase (private val repository: IMovieRepository) {
    suspend operator fun invoke(): List<Movie> = repository.fetchMovies()
}