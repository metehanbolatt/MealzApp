package com.metehanbolat.mealzapp.ui.details

import androidx.compose.animation.animateColor
import androidx.compose.animation.core.animateDp
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.updateTransition
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import coil.compose.rememberImagePainter
import com.metehanbolat.mealzapp.model.response.MealResponse

@Composable
fun MealDetailsScreen(meal: MealResponse?) {

    var profilePictureState by remember { mutableStateOf(MealProfilePictureState.Normal) }
    val transition = updateTransition(targetState = profilePictureState, label = "" )
    val imageSizeDp by transition.animateDp(targetValueByState = { it.size }, label = "" )
    val color by transition.animateColor(targetValueByState = { it.color }, label = "" )
    val widthSize by transition.animateDp(targetValueByState = { it.borderWidth }, label = "" )

    Column {
        Row {
            Card(
                modifier = Modifier.padding(16.dp),
                shape = CircleShape,
                border = BorderStroke(
                    width = widthSize,
                    color = color
                )
            ) {
                Image(
                    painter = rememberImagePainter(meal?.imageUrl),
                    contentDescription = "Meal Image",
                    modifier = Modifier
                        .size(imageSizeDp)
                        .padding(8.dp)
                )
            }
            Text(
                text = meal?.name ?: "Empty Meal",
                modifier = Modifier
                    .padding(16.dp)
                    .align(Alignment.CenterVertically)
            )
        }
        Button(onClick = {
            profilePictureState = if (profilePictureState == MealProfilePictureState.Normal){
                MealProfilePictureState.Expanded
            }else{
                MealProfilePictureState.Normal
            }
        }) {
            Text(
                text = "Change state of meal profile picture"
            )
        }
    }
}

enum class MealProfilePictureState(val color: Color, val size: Dp, val borderWidth: Dp){
    Normal(Color.Magenta, 120.dp, 8.dp),
    Expanded(Color.Green, 200.dp, 24.dp)
}