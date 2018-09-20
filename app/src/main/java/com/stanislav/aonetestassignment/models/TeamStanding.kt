package com.stanislav.aonetestassignment.models

import com.stanislav.aonetestassignment.models.TeamBasic

data class TeamStanding(
        val position: Int,
        val team: TeamBasic,
        val playedGames: Int,
        val won: Int,
        val draw: Int,
        val lost: Int,
        val points: Int,
        val goalsFor: Int,
        val goalsAgainst: Int,
        val goalDifference: Int
)