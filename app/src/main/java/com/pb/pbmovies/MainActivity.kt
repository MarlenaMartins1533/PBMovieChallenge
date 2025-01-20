@file:OptIn(ExperimentalMaterial3Api::class)

package com.pb.pbmovies

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.pb.pbmovies.data.remote.mapper.MovieToItemMovieMapper
import com.pb.pbmovies.domain.model.ItemMovie
import com.pb.pbmovies.domain.model.Movie
import com.pb.pbmovies.ui.VideoItemRow
import com.pb.pbmovies.ui.theme.PBMoviesTheme
import com.pb.pbmovies.ui.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : ComponentActivity() {
    private val mainViewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            PBMoviesTheme {
                MovieApp()
            }
        }
    }

    override fun onStart() {
        super.onStart()
        fetchMovies()
    }

    @Composable
    private fun MovieApp() {
        val movieData = mainViewModel.moviesData.collectAsState()
        VideoListScreen(videoItems = getListMovies(movieData.value))
    }

    private fun getListMovies(moviesListValue: List<Movie>): List<ItemMovie> {
        val apiMovie = MovieToItemMovieMapper().invoke(moviesListValue)
        return apiMovie + sampleVideos
    }

    private fun fetchMovies() {
        mainViewModel.fetchMovies()
    }
}

@Composable
fun VideoListScreen(videoItems: List<ItemMovie>) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(
                        text = "Videos/ - ${videoItems.size} files",
                        color = Color.White
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFF0F1562)
                ),
                actions = {
                    IconButton(onClick = { /* Handle dropdown icon click */ }) {
                        Icon(
                            painter = painterResource(id = R.drawable.ic_menu_foreground),
                            contentDescription = "Menu Icon",
                            tint = Color.White
                        )
                    }
                },
                modifier = Modifier.background(Color(0xFF0F1562))
            )
        },
        modifier = Modifier.fillMaxSize(),
        containerColor = Color.DarkGray,
        contentColor = Color.DarkGray,
        content = { paddingValues ->
            LazyColumn(
                modifier = Modifier
                    .padding(paddingValues)
                    .background(Color.DarkGray)
            ) {
                items(videoItems.size) { index ->
                    VideoItemRow(videoItem = videoItems[index])
                }
            }
        }
    )
}

// Mock data
var sampleVideos = listOf(
    ItemMovie(
        R.drawable.ic_folder_foreground,
        Movie(
            thumbnail = R.drawable.avatar,
            title = "Sample Title",
            year = "2015",
            seasonEpisode = "Season 2 Episode 4",
            genres = "Comedy, Drama, USA",
            rating = "7.0",
            info = " "
        )
    ),
    ItemMovie(
        R.drawable.ic_folder_foreground,
        Movie(
            thumbnail = android.R.drawable.ic_media_pause,
            title = "Another Sample Title",
            year = "2013",
            seasonEpisode = "Season 4 Episode 5",
            genres = "Comedy, Crime, USA",
            rating = "8.3",
            info = " "
        )
    ),
    ItemMovie(
        R.drawable.ic_folder_foreground,
        Movie(
            thumbnail = android.R.drawable.ic_media_pause,
            title = "Sample Title",
            year = "2015",
            seasonEpisode = "Season 2 Episode 4",
            genres = "Comedy, Drama, USA",
            rating = "7.0",
            info = " "
        )
    ),
    ItemMovie(
        R.drawable.ic_folder_foreground,
        Movie(
            thumbnail = android.R.drawable.ic_media_pause,
            title = "Another Sample Title",
            year = "2013",
            seasonEpisode = "Season 4 Episode 5",
            genres = "Comedy, Crime, USA",
            rating = "8.3",
            info = " "
        )
    ),

    )

@Composable
@Preview(showBackground = true)
fun VideoListScreenPreview() {
    VideoListScreen(videoItems = sampleVideos)
}