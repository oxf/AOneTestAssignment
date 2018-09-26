package com.stanislav.aonetestassignment.viewmodels

import android.arch.lifecycle.MutableLiveData
import android.view.View
import com.stanislav.aonetestassignment.R
import com.stanislav.aonetestassignment.models.TeamFull
import com.stanislav.aonetestassignment.services.FootballDataService
import com.stanislav.aonetestassignment.viewholders.TeamActivityViewHolder
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class TeamViewModel(val teamId: Long, val view: View) : BasicTeamViewModel() {
    @Inject
    lateinit var footballDataService: FootballDataService

    private lateinit var subscription: Disposable

    private val viewHolder: TeamActivityViewHolder = TeamActivityViewHolder(view)

    val loadingVisibility: MutableLiveData<Int> = MutableLiveData()
    val errorMessage: MutableLiveData<Int> = MutableLiveData()
    val errorClickListener = View.OnClickListener { loadStandings() }

    init {
        loadStandings()
    }

    private fun loadStandings() {
        subscription = footballDataService.getTeamById("78c992b4f65c4545b64af8540b937598", teamId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe { onRetrieveStandingsStart() }
                .doOnTerminate { onRetrieveStandingsFinish() }
                .subscribe(
                        { result -> onRetrieveStandingsSuccess(result) },
                        { error -> onRetrieveStandingsError(error) }
                )
    }

    override fun onCleared() {
        super.onCleared()
        subscription.dispose()
    }


    private fun onRetrieveStandingsStart() {
        loadingVisibility.value = View.VISIBLE
        errorMessage.value = null
    }

    private fun onRetrieveStandingsFinish() {
        loadingVisibility.value = View.GONE
    }

    private fun onRetrieveStandingsSuccess(result: TeamFull) {
        viewHolder.bindModel(result)
    }

    private fun onRetrieveStandingsError(error: Throwable) {
        error.printStackTrace()
        errorMessage.value = R.string.errorRetrievingStandings
    }

}