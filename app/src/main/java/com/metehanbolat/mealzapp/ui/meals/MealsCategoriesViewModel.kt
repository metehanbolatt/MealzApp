package com.metehanbolat.mealzapp.ui.meals

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.metehanbolat.mealzapp.model.MealsRepository
import com.metehanbolat.mealzapp.model.response.MealResponse
import kotlinx.coroutines.*

class MealsCategoriesViewModel(private val repository: MealsRepository = MealsRepository()) : ViewModel() {

    private val mealsJob = Job()

    init {
        val scope = CoroutineScope(mealsJob + Dispatchers.IO)
        scope.launch() {
            val meals = getMeals()
            mealsState.value = meals
        }
    }

    val mealsState =  mutableStateOf(emptyList<MealResponse>())

    private suspend fun getMeals() : List<MealResponse>{
        return repository.getMeals().categories
    }

    override fun onCleared() {
        super.onCleared()
        mealsJob.cancel()
    }
}