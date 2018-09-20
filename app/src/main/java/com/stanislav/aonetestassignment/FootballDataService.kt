package com.stanislav.aonetestassignment

import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path

interface FootballDataService {
    @GET("/v2/competitions/{competitionId}/teams")
    fun listTeams(@Header("X-Auth-Token") token: String, @Path("competitionId") competitionId: Long)
}