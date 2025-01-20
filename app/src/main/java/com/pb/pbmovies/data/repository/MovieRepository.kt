package com.pb.pbmovies.data.repository

import com.pb.pbmovies.data.remote.datasource.IMovieRemoteDataSource
import com.pb.pbmovies.domain.model.Movie
import com.pb.pbmovies.domain.repository.IMovieRepository

class MovieRepository(
    private val remoteDataSource: IMovieRemoteDataSource
): IMovieRepository {
    override suspend fun fetchMovies(): List<Movie> = remoteDataSource.fetchMovies()
}