package com.stanislav.aonetestassignment.viewmodels

import android.app.Application
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.stanislav.aonetestassignment.models.TeamStanding
import com.stanislav.aonetestassignment.repositories.StandingsRepository
import kotlinx.coroutines.experimental.launch
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.android.closestKodein
import org.kodein.di.generic.instance

class CompetitionViewModel(app: Application, val competitionId: Long) : ViewModel(), KodeinAware {
    override val kodein: Kodein by closestKodein(app)

    private val repository: StandingsRepository by instance()

    private val data: MutableLiveData<Map<Long, TeamStanding>> by lazy {
        MutableLiveData<Map<Long, TeamStanding>>()
                .also { fetchAndUpdate() }
    }

    suspend fun fetchData(): Map<Long, TeamStanding> = repository.getStandings(competitionId)

    fun fetchAndUpdate() =
            launch {
                fetchData().let(data::postValue)
            }
}