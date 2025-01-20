package com.pb.pbmovies.ui.composable

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
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.pb.pbmovies.R
import com.pb.pbmovies.ui.composable.model.ItemMovie
import com.pb.pbmovies.ui.composable.parameterprovider.movieListParameterProvider

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MovieListScreen(videoItems: List<ItemMovie>) {
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
                    MovieCard(videoItem = videoItems[index])
                }
            }
        }
    )
}

@Composable
@Preview(showBackground = true)
private fun MovieListScreenPreview() {
    MovieListScreen(videoItems = movieListParameterProvider)
}