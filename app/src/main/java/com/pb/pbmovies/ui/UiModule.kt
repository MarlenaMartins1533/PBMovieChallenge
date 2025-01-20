package com.pb.pbmovies.ui

import com.pb.pbmovies.ui.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val uiModule = module {
    viewModel { MainViewModel(getMovieUseCase = get()) }
}