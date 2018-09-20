package com.stanislav.aonetestassignment.models

import com.stanislav.aonetestassignment.models.Area

data class Competition(
        val id: Long,
        val area: Area,
        val name: String,
        val code: String
)
