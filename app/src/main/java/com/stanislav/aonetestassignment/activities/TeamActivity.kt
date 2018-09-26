package com.stanislav.aonetestassignment.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.stanislav.aonetestassignment.R
import com.stanislav.aonetestassignment.viewmodels.TeamViewModel
import com.stanislav.aonetestassignment.viewmodels.TeamViewModelFactory
import kotlinx.android.synthetic.main.activity_team.*

class TeamActivity : AppCompatActivity() {

    lateinit var viewModel: TeamViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_team)
        val teamId = intent.getLongExtra("teamId", 0)
        val factory = TeamViewModelFactory(teamId, teamActivity)

        viewModel = factory.create(TeamViewModel::class.java)
    }
}
