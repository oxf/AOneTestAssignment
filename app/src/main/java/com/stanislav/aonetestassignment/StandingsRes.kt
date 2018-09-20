package com.stanislav.aonetestassignment

data class StandingsRes(
        val competition: Competition,
        val season: Season,
        val standings: List<Standing>
)