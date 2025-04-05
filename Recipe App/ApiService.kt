package com.example.myrecipeapp

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

//This code sets up Retrofit to fetch data from the MealDB API.
private val retrofit = Retrofit.Builder()
    .baseUrl("https://www.themealdb.com/api/json/v1/1/")  // Converts JSON responses into Kotlin objects
    .addConverterFactory(GsonConverterFactory.create())
    .build()

val recipeService = retrofit.create(ApiService::class.java)

//Defining API request
interface ApiService {
    @GET("Categories.php")  //this comes from MealDB API, gets a list of food categories
    suspend fun getCategories(): CategoriesResponse
    //The function returns a CategoriesResponse, which will contain the data we get from the API.
}
