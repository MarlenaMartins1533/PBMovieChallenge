package com.pb.pbmovies.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.pb.pbmovies.R
import com.pb.pbmovies.VideoListScreen
import com.pb.pbmovies.domain.model.ItemMovie
import com.pb.pbmovies.sampleVideos

@Composable
fun VideoItemRow(videoItem: ItemMovie) {
    rememberScrollState()
    Card(
        shape = RoundedCornerShape(8.dp),
        modifier = Modifier
            .fillMaxWidth()
            .padding(5.dp)
            .border(1.dp, Color.LightGray),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
                .background(Color.DarkGray)
        ) {
            IconButton(
                onClick = { /* Handle expand click - pt.Trabalhos futuros */ },
                modifier = Modifier.align(Alignment.CenterVertically)
            ) {
                Icon(
                    painter = painterResource(id = videoItem.icon),
                    tint = Color.White,
                    contentDescription = "Info Icon"
                )
            }
            Image(
                painter = painterResource(id = R.drawable.avatar),
                contentDescription = "Video Thumbnail",
                modifier = Modifier
                    .size(120.dp)
                    .padding(1.dp)
                    .align(CenterVertically)
                // Geracao de imagens especificas para cada videoItem como trabalho futuro.
            )
            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(start = 8.dp)
            ) {
                Text(
                    text = videoItem.movie.title,
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp
                )
                Text(
                    text = "TV (${videoItem.movie.year}) ${videoItem.movie.seasonEpisode}",
                    fontWeight = FontWeight.Bold,
                    fontSize = 14.sp,
                    color = Color.White
                )
                Row(modifier = Modifier.fillMaxWidth()) {
                    Column(
                        modifier = Modifier
                            .weight(1f)
                            .align(Alignment.CenterVertically)
                    ) {
                        Text(
                            text = videoItem.movie.genres ?: "",
                            fontSize = 14.sp,
                            color = Color.White
                        )
                        Text(
                            text = "IMDB Rating: ${videoItem.movie.rating}",
                            fontSize = 14.sp,
                            color = Color.White,
                        )
                    }
                    IconButton(
                        onClick = { /* Handle expand click to see more infos */ },
                        modifier = Modifier.align(Alignment.Bottom)
                    ) {
                        Icon(
                            painter = painterResource(id = android.R.drawable.ic_dialog_info),
                            tint = Color.White,
                            contentDescription = "Info Icon"
                        )
                    }
                }
            }
            IconButton(
                onClick = { /* Handle expand click to see more infos */ },
                modifier = Modifier.align(Alignment.CenterVertically)
            ) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_arrow_drop_down_foreground),
                    tint = Color.White,
                    contentDescription = "Info Icon"
                )
            }
        }
    }
}

@Composable
@Preview(showBackground = true)
fun VideoListScreenPreview() {
    VideoListScreen(videoItems = sampleVideos)
}