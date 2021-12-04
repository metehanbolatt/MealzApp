package com.metehanbolat.mealzapp.model

import com.metehanbolat.mealzapp.model.response.MealsCategoriesResponse

class MealsRepository {

    fun getMeals() : MealsCategoriesResponse = MealsCategoriesResponse(arrayListOf())
    
}