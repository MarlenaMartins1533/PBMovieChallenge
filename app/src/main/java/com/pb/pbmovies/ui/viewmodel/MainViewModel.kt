package com.pb.pbmovies.ui.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pb.pbmovies.domain.model.Movie
import com.pb.pbmovies.domain.usecase.GetMovieUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import retrofit2.HttpException

class MainViewModel(
    private val getMovieUseCase: GetMovieUseCase
) : ViewModel() {
    private val _moviesData = MutableStateFlow<List<Movie>>(emptyList())
    val moviesData = _moviesData.asStateFlow()

    fun fetchMovies() {
        viewModelScope.launch {
            try {
                getMovieUseCase().run {
                    _moviesData.value = this
                }
            } catch (e: HttpException) {
                Log.e("error", e.message ?: "ERROR")
            }
        }
    }
}