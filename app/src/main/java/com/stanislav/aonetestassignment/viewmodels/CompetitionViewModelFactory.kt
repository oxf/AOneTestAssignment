package com.stanislav.aonetestassignment.viewmodels

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider


class CompetitionViewModelFactory(
        private val competitionId: Long) : ViewModelProvider.NewInstanceFactory() {


    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return StandingsViewModel(competitionId) as T
    }
}