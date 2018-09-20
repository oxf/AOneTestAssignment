package com.stanislav.aonetestassignment

import java.text.FieldPosition

data class TeamStanding(
        val position: Int,
        val team: Team,
        val playedGames: Int,
        val won: Int,
        val draw: Int,
        val lost: Int,
        val points: Int,
        val goalsFor: Int,
        val goalsAgainst: Int,
        val goalDifference: Int
)