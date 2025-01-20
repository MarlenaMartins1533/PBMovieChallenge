package com.pb.pbmovies.data.remote.datasource

import com.pb.pbmovies.data.remote.mapper.MovieMapper
import com.pb.pbmovies.data.remote.service.OMDbApi
import com.pb.pbmovies.domain.model.Movie

class MovieRemoteDataSource(
    private val api: OMDbApi,
    private val mapper: MovieMapper
) : IMovieRemoteDataSource {
    override suspend fun fetchMovies(): List<Movie> =
        listOf(mapper(api.getMovie()))
}
