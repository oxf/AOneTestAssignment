package com.stanislav.aonetestassignment.models

data class Season(
        val id: Long,
        val startDate: String,
        val endDate: String,
        val currentMatchday: Int
)