package com.stanislav.aonetestassignment.viewmodels

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.content.Context


class CompetitionViewModelFactory(
        private val competitionId: Long,
        private val context: Context) : ViewModelProvider.NewInstanceFactory() {


    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return StandingsViewModel(competitionId, context) as T
    }
}