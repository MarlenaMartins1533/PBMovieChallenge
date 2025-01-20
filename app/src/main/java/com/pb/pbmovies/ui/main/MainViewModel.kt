package com.pb.pbmovies.ui.main

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pb.pbmovies.domain.usecase.GetMovieUseCase
import com.pb.pbmovies.ui.composable.mapper.MovieToItemMovieMapper
import com.pb.pbmovies.ui.composable.model.ItemMovie
import kotlinx.coroutines.launch
import retrofit2.HttpException

class MainViewModel(
    private val getMovieUseCase: GetMovieUseCase,
    private val movieToItemMapper: MovieToItemMovieMapper
) : ViewModel() {

    private val _moviesData = mutableStateOf<List<ItemMovie>>(emptyList())
    val moviesData: State<List<ItemMovie>> = _moviesData

    fun fetchMovies() {
        viewModelScope.launch {
            try {
                _moviesData.value = movieToItemMapper.invoke(getMovieUseCase())
            } catch (e: HttpException) {
                Log.e("error", e.message ?: "ERROR")
            }
        }
    }
}