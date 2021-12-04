package com.metehanbolat.mealzapp.model

import com.metehanbolat.mealzapp.model.api.MealsWebService
import com.metehanbolat.mealzapp.model.response.MealsCategoriesResponse

class MealsRepository(private val webService: MealsWebService = MealsWebService()) {

    suspend fun getMeals(): MealsCategoriesResponse {
        return webService.getMeals()
    }
}