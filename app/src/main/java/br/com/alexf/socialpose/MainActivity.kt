package br.com.alexf.socialpose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import br.com.alexf.socialpose.features.feed.FeedScreen
import br.com.alexf.socialpose.ui.theme.SocialPoseTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SocialPoseTheme {
                FeedScreen()
            }
        }
    }
}