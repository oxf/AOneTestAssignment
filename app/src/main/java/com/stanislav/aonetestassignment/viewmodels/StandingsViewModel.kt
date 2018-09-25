package com.stanislav.aonetestassignment.viewmodels

import android.arch.lifecycle.MutableLiveData
import android.content.Context
import android.view.View
import com.stanislav.aonetestassignment.R
import com.stanislav.aonetestassignment.adapters.StandingsRecyclerViewAdapter
import com.stanislav.aonetestassignment.models.StandingsRes
import com.stanislav.aonetestassignment.services.FootballDataService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class StandingsViewModel(val competitionId: Long, private val context: Context) : BasicViewModel() {
    @Inject
    lateinit var footballDataService: FootballDataService

    private lateinit var subscription: Disposable

    val loadingVisibility: MutableLiveData<Int> = MutableLiveData()

    val errorMessage: MutableLiveData<Int> = MutableLiveData()
    val errorClickListener = View.OnClickListener { loadStandings() }

    val standingsRecyclerViewAdapter: StandingsRecyclerViewAdapter = StandingsRecyclerViewAdapter(context)

    init {
        loadStandings()
    }

    private fun loadStandings() {
        subscription = footballDataService.listStandingsForLeague("78c992b4f65c4545b64af8540b937598", competitionId)
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

    private fun onRetrieveStandingsSuccess(result: StandingsRes) {
        standingsRecyclerViewAdapter.updatePostList(result.standings[0].table)
    }

    private fun onRetrieveStandingsError(error: Throwable) {
        error.printStackTrace()
        errorMessage.value = R.string.errorRetrievingStandings
    }

}