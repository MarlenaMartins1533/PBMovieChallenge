package com.pb.pbmovies.data.remote.service

import com.pb.pbmovies.data.model.MovieResponse
import retrofit2.http.GET
import retrofit2.http.Query

private const val API_KEY = "bbcb9a4f"

interface OMDbApi {
    @GET("?")
    suspend fun getMovie(
        @Query("t") title: String = "start",
        @Query("apikey") apiKey: String = API_KEY
    ): MovieResponse
}