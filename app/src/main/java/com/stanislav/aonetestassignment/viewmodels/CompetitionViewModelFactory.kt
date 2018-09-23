package com.stanislav.aonetestassignment.viewmodels

import android.app.Application
import android.arch.lifecycle.ViewModelProvider


class CompetitionViewModelFactory(
        private val mApplication: Application,
        private val competitionId: Long) : ViewModelProvider.NewInstanceFactory() {


//    override fun <T : ViewModel> create(modelClass: Class<T>): T {
//        return StandingsViewModel(mApplication, competitionId) as T
//    }
}