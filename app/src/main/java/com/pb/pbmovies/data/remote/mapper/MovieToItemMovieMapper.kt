package com.pb.pbmovies.data.remote.mapper

import com.pb.pbmovies.R
import com.pb.pbmovies.domain.model.ItemMovie
import com.pb.pbmovies.domain.model.Movie
import com.pb.pbmovies.util.Mapper

class MovieToItemMovieMapper : Mapper<List<Movie>, List<ItemMovie>> {
    override operator fun invoke(input: List<Movie>): List<ItemMovie> =
        input.map {
            ItemMovie(
                icon = R.drawable.ic_movie_foreground,
                movie = it
            )
        }
}
