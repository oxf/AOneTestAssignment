package com.stanislav.aonetestassignment.repositories

import com.stanislav.aonetestassignment.models.TeamFull
import com.stanislav.aonetestassignment.services.FootballDataService

class TeamRepository(
        val service: FootballDataService,
        val token: String
) {
    suspend fun getTeamById(teamId: Long): TeamFull =
            service.getTeamById(token, teamId).await()
}