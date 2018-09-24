package com.stanislav.aonetestassignment.services

import com.stanislav.aonetestassignment.models.StandingsRes
import com.stanislav.aonetestassignment.models.TeamFull
import io.reactivex.Observable
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path

interface FootballDataService {
    @GET("/v2/teams/{id}")
    fun getTeamById(@Header("X-Auth-Token") token: String, @Path("teamId") competitionId: Long): Single<TeamFull>

    @GET("/v2/competitions/{competitionId}/standings")
    fun listStandingsForLeague(@Header("X-Auth-Token") token: String, @Path("competitionId") competitionId: Long): Observable<StandingsRes>
}