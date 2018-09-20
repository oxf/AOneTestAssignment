package com.stanislav.aonetestassignment.models

import com.stanislav.aonetestassignment.models.Area

data class TeamFull(
        val id: Long,
        val area: Area,
        val name: String,
        val shortName: String,
        val tla: String,
        val crestUrl: String,
        val address: String,
        val phone: String,
        val website: String,
        val email: String,
        val founded: Int,
        val clubColors: String,
        val venue: String
)