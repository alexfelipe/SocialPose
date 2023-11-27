package br.com.alexf.socialpose.features.feed

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import br.com.alexf.socialpose.samples.generateLorem
import br.com.alexf.socialpose.samples.generateUrlImage
import br.com.alexf.socialpose.ui.theme.SocialPoseTheme
import kotlin.random.Random

@Composable
fun FeedScreen() {
    LazyColumn(Modifier.fillMaxSize()) {
        items(10) {
            var isLiked by rememberSaveable {
                mutableStateOf(false)
            }
            val title = rememberSaveable {
                generateLorem(Random.nextInt(2, 10))
            }
            val likes = rememberSaveable {
                "${Random.nextInt(2, 1000)}"
            }
            val imageUrl = rememberSaveable {
                generateUrlImage()
            }
            PostItem(
                imageUrl = imageUrl,
                title = title,
                likes = likes,
                isLiked = isLiked,
                onLikeClick = { isLiked = !isLiked },
                Modifier.fillParentMaxHeight()
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun FeedScreenPreview() {
    SocialPoseTheme {
        FeedScreen()
    }
}