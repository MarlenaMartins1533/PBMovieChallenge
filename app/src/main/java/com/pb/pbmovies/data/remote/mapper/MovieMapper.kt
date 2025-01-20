package com.pb.pbmovies.data.remote.mapper

import com.pb.pbmovies.util.Mapper
import com.pb.pbmovies.data.model.MovieResponse
import com.pb.pbmovies.domain.model.Movie

class MovieMapper : Mapper<MovieResponse, Movie> {
    override operator fun invoke(input: MovieResponse): Movie = Movie(
        thumbnail = 0,
        title = input.title,
        year = input.year,
        seasonEpisode = "",
        genres = input.genre,
        rating = input.imdbRating,
        info = input.plot
    )
}
