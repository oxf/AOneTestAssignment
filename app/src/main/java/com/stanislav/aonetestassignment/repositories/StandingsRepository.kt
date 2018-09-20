package com.stanislav.aonetestassignment.repositories

import com.stanislav.aonetestassignment.models.TeamStanding
import com.stanislav.aonetestassignment.services.FootballDataService

class StandingsRepository(
        val service: FootballDataService,
        val token: String
) {
    suspend fun getStandings(competitionId: Long): Map<Long, TeamStanding> =
            service.listStandingsForLeague(token, competitionId).await().table.map { it.position.toLong() to it }.toMap()
}