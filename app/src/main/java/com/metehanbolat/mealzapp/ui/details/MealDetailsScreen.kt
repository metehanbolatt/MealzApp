package com.metehanbolat.mealzapp.ui.details

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.max
import coil.compose.rememberImagePainter
import com.metehanbolat.mealzapp.model.response.MealResponse
import kotlin.math.min

@Composable
fun MealDetailsScreen(meal: MealResponse?) {

    val scrollState = rememberScrollState()
    val offset = min(1f, 1 - (scrollState.value / 600f))
    val size by animateDpAsState(targetValue = max(100.dp, 200.dp * offset))

    Surface(color = MaterialTheme.colors.background) {
        Column {
            Surface(elevation = 4.dp) {
                Row(modifier = Modifier.fillMaxWidth()) {
                    Card(
                        modifier = Modifier.padding(16.dp),
                        shape = CircleShape,
                        border = BorderStroke(
                            width = 2.dp,
                            color = Color.Green
                        )
                    ) {
                        Image(
                            painter = rememberImagePainter(meal?.imageUrl),
                            contentDescription = "Meal Image",
                            modifier = Modifier
                                .size(size)
                        )
                    }
                    Text(
                        text = meal?.name ?: "Empty Meal",
                        modifier = Modifier
                            .padding(16.dp)
                            .align(Alignment.CenterVertically)
                    )
                }
            }
            Column(modifier = Modifier.verticalScroll(scrollState)) {
                Text(text = "This is a text element", modifier = Modifier.padding(32.dp))
                Text(text = "This is a text element", modifier = Modifier.padding(32.dp))
                Text(text = "This is a text element", modifier = Modifier.padding(32.dp))
                Text(text = "This is a text element", modifier = Modifier.padding(32.dp))
                Text(text = "This is a text element", modifier = Modifier.padding(32.dp))
                Text(text = "This is a text element", modifier = Modifier.padding(32.dp))
                Text(text = "This is a text element", modifier = Modifier.padding(32.dp))
                Text(text = "This is a text element", modifier = Modifier.padding(32.dp))
                Text(text = "This is a text element", modifier = Modifier.padding(32.dp))
                Text(text = "This is a text element", modifier = Modifier.padding(32.dp))
                Text(text = "This is a text element", modifier = Modifier.padding(32.dp))
                Text(text = "This is a text element", modifier = Modifier.padding(32.dp))
                Text(text = "This is a text element", modifier = Modifier.padding(32.dp))
                Text(text = "This is a text element", modifier = Modifier.padding(32.dp))
                Text(text = "This is a text element", modifier = Modifier.padding(32.dp))
                Text(text = "This is a text element", modifier = Modifier.padding(32.dp))
                Text(text = "This is a text element", modifier = Modifier.padding(32.dp))
                Text(text = "This is a text element", modifier = Modifier.padding(32.dp))
                Text(text = "This is a text element", modifier = Modifier.padding(32.dp))
                Text(text = "This is a text element", modifier = Modifier.padding(32.dp))
                Text(text = "This is a text element", modifier = Modifier.padding(32.dp))
                Text(text = "This is a text element", modifier = Modifier.padding(32.dp))
                Text(text = "This is a text element", modifier = Modifier.padding(32.dp))
                Text(text = "This is a text element", modifier = Modifier.padding(32.dp))
            }
        }
    }

}