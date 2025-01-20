package com.pb.pbmovies.domain.model

data class Movie(
    val thumbnail: Int = 0,
    val title: String,
    val year: String,
    val seasonEpisode: String = " ",
    val genres: String,
    val rating: String,
    val info: String
)