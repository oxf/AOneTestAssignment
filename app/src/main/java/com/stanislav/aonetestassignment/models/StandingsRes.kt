package com.stanislav.aonetestassignment.models

data class StandingsRes(
        val competition: Competition,
        val season: Season,
        val standings: List<Standing>,
        val filters: Any?
)