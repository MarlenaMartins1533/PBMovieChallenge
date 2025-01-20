package com.pb.pbmovies.ui.composable.parameterprovider

import com.pb.pbmovies.R
import com.pb.pbmovies.ui.composable.model.ItemMovie
import com.pb.pbmovies.domain.model.Movie

// Mock data
var movieListParameterProvider = listOf(
    ItemMovie(
        R.drawable.ic_folder_foreground,
        Movie(
            thumbnail = R.drawable.avatar,
            title = "Sample Title",
            year = "2015",
            seasonEpisode = "Season 2 Episode 4",
            genres = "Comedy, Drama, USA",
            rating = "7.0",
            info = " "
        )
    ),
    ItemMovie(
        R.drawable.ic_folder_foreground,
        Movie(
            thumbnail = android.R.drawable.ic_media_pause,
            title = "Another Sample Title",
            year = "2013",
            seasonEpisode = "Season 4 Episode 5",
            genres = "Comedy, Crime, USA",
            rating = "8.3",
            info = " "
        )
    ),
    ItemMovie(
        R.drawable.ic_folder_foreground,
        Movie(
            thumbnail = android.R.drawable.ic_media_pause,
            title = "Sample Title",
            year = "2015",
            seasonEpisode = "Season 2 Episode 4",
            genres = "Comedy, Drama, USA",
            rating = "7.0",
            info = " "
        )
    ),
    ItemMovie(
        R.drawable.ic_folder_foreground,
        Movie(
            thumbnail = android.R.drawable.ic_media_pause,
            title = "Another Sample Title",
            year = "2013",
            seasonEpisode = "Season 4 Episode 5",
            genres = "Comedy, Crime, USA",
            rating = "8.3",
            info = " "
        )
    ),
)