package com.metehanbolat.mealzapp.ui.details

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.metehanbolat.mealzapp.model.response.MealResponse

@Composable
fun MealDetailsScreen(meal: MealResponse?) {
    Column {
        Row {
            Card {
                Image(
                    painter = rememberImagePainter(meal?.imageUrl),
                    contentDescription = "Meal Image",
                    modifier = Modifier.size(200.dp)
                )
            }
            Text(text = meal?.name ?: "Empty Meal")
        }
        Button(onClick = { /*TODO*/ }) {
            Text(text = "Change state of meal profile picture")
        }
    }
}