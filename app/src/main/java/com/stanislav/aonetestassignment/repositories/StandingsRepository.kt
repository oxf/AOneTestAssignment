package com.stanislav.aonetestassignment.repositories

import com.stanislav.aonetestassignment.services.FootballDataService

class StandingsRepository(
        val service: FootballDataService,
        val token: String
) {
    private inline fun <T> safeCall(default: () -> T, call: () -> T): T = try {
        call()
    } catch (e: Exception) {
        default()
    }


//    suspend fun getStandings(competitionId: Long): Map<Int, TeamStanding> = safeCall(::mapOf) {
//        service.listStandingsForLeague(token, competitionId)..table.associateBy(TeamStanding::position)
//    }
}