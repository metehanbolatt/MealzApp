package com.metehanbolat.mealzapp.ui.meals

import androidx.lifecycle.ViewModel
import com.metehanbolat.mealzapp.model.MealsRepository
import com.metehanbolat.mealzapp.model.response.MealResponse
import com.metehanbolat.mealzapp.model.response.MealsCategoriesResponse

class MealsCategoriesViewModel(private val repository: MealsRepository = MealsRepository()) : ViewModel() {
    fun getMeals(successCallback: (response: MealsCategoriesResponse?) -> Unit){
        repository.getMeals { response ->
            successCallback(response)
        }
    }
}