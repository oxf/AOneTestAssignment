package com.stanislav.aonetestassignment.models

import com.stanislav.aonetestassignment.models.Competition
import com.stanislav.aonetestassignment.models.Season
import com.stanislav.aonetestassignment.models.Standing

data class StandingsRes(
        val competition: Competition,
        val season: Season,
        val standings: List<Standing>
)