package com.stanislav.aonetestassignment.viewmodels

import android.arch.lifecycle.ViewModel
import com.stanislav.aonetestassignment.di.DaggerTeamInjector
import com.stanislav.aonetestassignment.di.NetworkModule
import com.stanislav.aonetestassignment.di.TeamInjector

abstract class BasicTeamViewModel : ViewModel() { //TODO do some better polymorphism
    private val injector: TeamInjector = DaggerTeamInjector
            .builder()
            .networkModule(NetworkModule)
            .build()

    init {
        inject()
    }

    /**
     * Injects the required dependencies
     */
    private fun inject() {
        when (this) {
            is TeamViewModel -> injector.inject(this)
        }
    }
}