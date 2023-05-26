package dme.systems.brainbobapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dme.systems.brainbobapp.ui.theme.BrainBobAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DefaultPreview()
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun DefaultPreview() {
    val genres = listOf("Brainstorm", "Books", "Video", "Others")

    BrainBobAppTheme {
        Scaffold { paddingValues ->
            Column(
                modifier = Modifier
                    .background(Color.White)
                    .padding(paddingValues)
            ) {
                Text(
                    fontSize = 40.sp,
                    modifier = Modifier
                        .padding(start = 16.dp, top = 16.dp, bottom = 25.dp),
                    text = buildAnnotatedString {
                        append("Choose What\n")
                        withStyle(
                            style = SpanStyle(
                                fontWeight = FontWeight.Bold,
                                color = Color.Black
                            )
                        ) {
                            append("to learn today?")
                        }
                    })
                LazyRow(
                    horizontalArrangement = Arrangement.spacedBy(10.dp),
                ) {
                    items(genres) { genre ->
                        Genre(genre)
                    }
                }
            }

        }
    }
}

@Composable
fun Genre(genre: String) {
    var isSelected by remember { mutableStateOf(false) }
    Box(
        modifier = Modifier
            .clip(RoundedCornerShape(30))
            .background(if (isSelected) Color.Black else colorResource(id = R.color.seal))
            .clickable {
                isSelected = !isSelected
            },
        contentAlignment = Alignment.Center
    ) {
        Text(
            modifier = Modifier.padding(10.dp),
            text = genre,
            color = if (isSelected) Color.White else Color.Black,
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold
        )
    }

}
