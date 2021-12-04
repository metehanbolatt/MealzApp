package com.metehanbolat.mealzapp.model

import com.metehanbolat.mealzapp.model.api.MealsWebService
import com.metehanbolat.mealzapp.model.response.MealResponse
import com.metehanbolat.mealzapp.model.response.MealsCategoriesResponse

class MealsRepository(private val webService: MealsWebService = MealsWebService()) {

    private var cachedMeals = listOf<MealResponse>()

    suspend fun getMeals(): MealsCategoriesResponse {
        val response = webService.getMeals()
        cachedMeals = response.categories
        return response
    }

    fun getMeal(id: String): MealResponse? {
        return cachedMeals.firstOrNull {
            it.id == id
        }
    }

    companion object {
        @Volatile
        private var instance: MealsRepository? = null

        fun getInstance() = instance ?: synchronized(this){
            instance ?: MealsRepository().also { instance = it }
        }
    }
}