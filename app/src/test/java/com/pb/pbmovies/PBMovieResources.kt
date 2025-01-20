package com.pb.pbmovies

import com.pb.pbmovies.domain.model.Movie
import org.mockito.ArgumentMatchers.anyInt
import org.mockito.ArgumentMatchers.anyString

object Resources {
    val dummyMovie = mutableListOf(
        Movie(
            thumbnail = anyInt(),
            title = anyString(),
            year = anyString(),
            seasonEpisode = anyString(),
            genres = anyString(),
            rating = anyString(),
            info = anyString()
        )
    )
//    val errorResponse = Throwable("Error")
}