package com.metehanbolat.mealzapp.ui.meals

import androidx.lifecycle.ViewModel
import com.metehanbolat.mealzapp.model.MealsRepository
import com.metehanbolat.mealzapp.model.response.MealResponse

class MealsCategoriesViewModel(private val repository: MealsRepository = MealsRepository()) : ViewModel() {
    fun getMeals(): List<MealResponse>{
        return repository.getMeals().categories
    }
}