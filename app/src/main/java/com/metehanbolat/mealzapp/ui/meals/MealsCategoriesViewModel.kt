package com.metehanbolat.mealzapp.ui.meals

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.metehanbolat.mealzapp.model.MealsRepository
import com.metehanbolat.mealzapp.model.response.MealResponse
import kotlinx.coroutines.*

class MealsCategoriesViewModel(private val repository: MealsRepository = MealsRepository.getInstance()) : ViewModel() {

    init {
        viewModelScope.launch(Dispatchers.IO) {
            val meals = getMeals()
            mealsState.value = meals
        }
    }

    val mealsState =  mutableStateOf(emptyList<MealResponse>())

    private suspend fun getMeals() : List<MealResponse>{
        return repository.getMeals().categories
    }
}