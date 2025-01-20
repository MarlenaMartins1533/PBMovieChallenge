package com.pb.pbmovies.data

import com.pb.pbmovies.data.remote.datasource.IMovieRemoteDataSource
import com.pb.pbmovies.data.remote.datasource.MovieRemoteDataSource
import com.pb.pbmovies.data.remote.mapper.MovieMapper
import com.pb.pbmovies.data.remote.service.OMDbApi
import com.pb.pbmovies.data.repository.MovieRepository
import com.pb.pbmovies.domain.repository.IMovieRepository
import com.pb.pbmovies.domain.usecase.GetMovieUseCase
import com.pb.pbmovies.ui.main.MainViewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val dataModule = module {
    factory { GsonConverterFactory.create() }
    factory {
        Retrofit.Builder()
            .baseUrl("https://www.omdbapi.com/")
            .addConverterFactory(get<GsonConverterFactory>())
            .build()
    }
    factory { get<Retrofit>().create(OMDbApi::class.java) }

    factory { MovieMapper() }
    factory<IMovieRemoteDataSource> {
        MovieRemoteDataSource(
            api = get(),
            mapper = get()
        )
    }
    factory<IMovieRepository> { MovieRepository(get()) }
}
