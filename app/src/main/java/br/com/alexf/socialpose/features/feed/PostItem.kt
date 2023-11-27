package br.com.alexf.socialpose.features.feed

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.FavoriteBorder
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.alexf.socialpose.samples.generateLorem
import br.com.alexf.socialpose.ui.theme.SocialPoseTheme
import coil.compose.SubcomposeAsyncImage
import kotlin.random.Random

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun PostItem(
    imageUrl: String,
    title: String,
    likes: String,
    isLiked: Boolean,
    onLikeClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(modifier) {
        SubcomposeAsyncImage(
            model = imageUrl,
            contentDescription = "Post image",
            Modifier
                .fillMaxWidth()
                .weight(1f)
                .combinedClickable(onClick = { },
                    onDoubleClick = {
                        onLikeClick()
                    }),
            loading = {
                Box {
                    CircularProgressIndicator(
                        Modifier.align(Alignment.Center)
                    )
                }
            },
            contentScale = ContentScale.Crop
        )
        Row(Modifier.padding(8.dp)) {
            Column {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    val likeModifier = Modifier.clickable {
                        onLikeClick()
                    }
                    when (isLiked) {
                        true -> Icon(
                            Icons.Filled.Favorite,
                            contentDescription = "favorite icon",
                            likeModifier,
                            tint = Color.Red
                        )

                        else -> Icon(
                            Icons.Filled.FavoriteBorder,
                            contentDescription = "favorite icon",
                            likeModifier
                        )
                    }
                    Spacer(Modifier.padding(8.dp))
                    Text(text = likes)
                }
                Spacer(modifier = Modifier.size(8.dp))
                Text(text = title)
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PostItemPreview() {
    SocialPoseTheme {
        PostItem(
            imageUrl = "",
            title = generateLorem(5),
            likes = Random.nextInt(1, 1000).toString(),
            isLiked = true,
            onLikeClick = {}
        )
    }
}

