package com.pb.pbmovies.domain

import com.pb.pbmovies.domain.usecase.GetMovieUseCase
import org.koin.dsl.module

val domainModule = module {
    factory { GetMovieUseCase(get()) }
}
