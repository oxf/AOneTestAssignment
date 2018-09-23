package com.stanislav.aonetestassignment.viewmodels

import android.arch.lifecycle.MutableLiveData
import android.view.View
import com.stanislav.aonetestassignment.services.FootballDataService
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class StandingsViewModel : BasicViewModel() {
    @Inject
    lateinit var footballDataService: FootballDataService

    private lateinit var subscription: Disposable

    val loadingVisibility: MutableLiveData<Int> = MutableLiveData()

    init {
        loadStandings()
    }

    private fun loadStandings() {
        subscription = footballDataService.listStandingsForLeague("asdf", 2002)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe { onRetrieveStandingsStart() }
//                .doOnTerminate { onRetrieveStandingsFinish() }
                .subscribe(
                        { onRetrieveStandingsSuccess() },
                        { onRetrieveStandingsError() }
                )
    }

    override fun onCleared() {
        super.onCleared()
        subscription.dispose()
    }


    private fun onRetrieveStandingsStart() {
        loadingVisibility.value = View.VISIBLE
    }

    private fun onRetrieveStandingsFinish() {
        loadingVisibility.value = View.GONE
    }

    private fun onRetrieveStandingsSuccess() {

    }

    private fun onRetrieveStandingsError() {

    }

}