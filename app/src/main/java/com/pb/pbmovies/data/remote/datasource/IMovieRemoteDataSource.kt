package com.pb.pbmovies.data.remote.datasource

import com.pb.pbmovies.domain.model.Movie


interface IMovieRemoteDataSource {
    suspend fun fetchMovies(): List<Movie>
}
