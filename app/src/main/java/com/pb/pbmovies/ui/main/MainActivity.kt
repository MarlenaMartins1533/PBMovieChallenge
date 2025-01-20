@file:OptIn(ExperimentalMaterial3Api::class)

package com.pb.pbmovies.ui.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.ExperimentalMaterial3Api
import com.pb.pbmovies.ui.composable.MovieListScreen
import com.pb.pbmovies.ui.composable.model.ItemMovie
import com.pb.pbmovies.ui.composable.parameterprovider.movieListParameterProvider
import com.pb.pbmovies.ui.theme.PBMoviesTheme
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : ComponentActivity() {
    private val mainViewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PBMoviesTheme {
                val movieData = mainViewModel.moviesData
                MovieListScreen(videoItems = generateMovieList(movieData.value))
            }
        }
    }

    override fun onStart() {
        super.onStart()
        fetchMovies()
    }

    private fun fetchMovies() {
        mainViewModel.fetchMovies()
    }

    // Adicionando o item retornado pela api e adicionando mais itens simulando um banco local de filmes.
    // Implementar room para banco de filmes como trabalho futuro.
    private fun generateMovieList(moviesList: List<ItemMovie>): List<ItemMovie> {
        return moviesList + movieListParameterProvider
    }
}
