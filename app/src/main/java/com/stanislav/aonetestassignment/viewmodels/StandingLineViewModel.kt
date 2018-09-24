package com.stanislav.aonetestassignment.viewmodels

import android.arch.lifecycle.MutableLiveData
import com.stanislav.aonetestassignment.models.TeamStanding


class StandingLineViewModel : BasicViewModel() {
    private val position = MutableLiveData<String>()
    private val name = MutableLiveData<String>()
    private val points = MutableLiveData<String>()
    private val playedGames = MutableLiveData<String>()
    private val won = MutableLiveData<String>()
    private val draw = MutableLiveData<String>()
    private val lost = MutableLiveData<String>()
    private val goalsFor = MutableLiveData<String>()
    private val goalsAgainst = MutableLiveData<String>()
    private val goalDifference = MutableLiveData<String>()


    fun bind(teamStanding: TeamStanding) {
        position.value = teamStanding.position.toString()
        name.value = teamStanding.team.name
        points.value = teamStanding.points.toString()
        playedGames.value = teamStanding.playedGames.toString()
        won.value = teamStanding.won.toString()
        draw.value = teamStanding.draw.toString()
        lost.value = teamStanding.lost.toString()
        goalsFor.value = teamStanding.goalsFor.toString()
        goalsAgainst.value = teamStanding.goalsAgainst.toString()
        goalDifference.value = teamStanding.goalDifference.toString()

    }

    fun getTeamPosition(): MutableLiveData<String> {
        return position
    }

    fun getTeamName(): MutableLiveData<String> {
        return name
    }

    fun getPoints(): MutableLiveData<String> {
        return points
    }

    fun getPlayedGames(): MutableLiveData<String> {
        return playedGames
    }

    fun getWon(): MutableLiveData<String> {
        return won
    }

    fun getDraw(): MutableLiveData<String> {
        return draw
    }

    fun getLost(): MutableLiveData<String> {
        return lost
    }

    fun getGoalsFor(): MutableLiveData<String> {
        return goalsFor
    }

    fun getGoalsAgainst(): MutableLiveData<String> {
        return goalsAgainst
    }

    fun getGoalDifference(): MutableLiveData<String> {
        return goalDifference
    }
}