package com.stanislav.aonetestassignment.services

import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class FootballDataServiceProvider(private val url: String) {
    fun getFootballDataService() = Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(MoshiConverterFactory.create())
}