package br.com.alexf.socialpose.samples

import androidx.compose.ui.tooling.preview.datasource.LoremIpsum
import kotlin.random.Random

fun generateLorem(amount: Int = 1) =
    LoremIpsum(Random.nextInt(1, amount)).values.first()

fun generateUrlImage() =
    "https://picsum.photos/${Random.nextInt(1280, 1920)}/${Random.nextInt(720, 1080)}"
