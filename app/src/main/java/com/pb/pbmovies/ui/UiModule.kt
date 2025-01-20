package com.pb.pbmovies.ui

import com.pb.pbmovies.ui.composable.mapper.MovieToItemMovieMapper
import com.pb.pbmovies.ui.main.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val uiModule = module {
    factory { MovieToItemMovieMapper() }

    viewModel {
        MainViewModel(
            getMovieUseCase = get(),
            movieToItemMapper = get()
        )
    }
}