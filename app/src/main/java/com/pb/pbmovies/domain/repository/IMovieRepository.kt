package com.pb.pbmovies.domain.repository

import com.pb.pbmovies.domain.model.Movie

interface IMovieRepository {
    suspend fun fetchMovies(): List<Movie>
}