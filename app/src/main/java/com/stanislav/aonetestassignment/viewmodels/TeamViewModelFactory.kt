package com.stanislav.aonetestassignment.viewmodels

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.view.View

class TeamViewModelFactory(
        private val teamId: Long,
        private val view: View) : ViewModelProvider.NewInstanceFactory() {


    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return TeamViewModel(teamId, view) as T
    }
}