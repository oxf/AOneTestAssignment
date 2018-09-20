package com.stanislav.aonetestassignment.models

data class Standing(
     val stage: String,
     val type: String,
     val group: String?,
     val table: List<TeamStanding>
)