package com.stanislav.aonetestassignment.viewmodels

import android.arch.lifecycle.ViewModel
import com.stanislav.aonetestassignment.di.DaggerViewModelInjector
import com.stanislav.aonetestassignment.di.NetworkModule
import com.stanislav.aonetestassignment.di.ViewModelInjector

abstract class BasicViewModel : ViewModel() {
    private val injector: ViewModelInjector = DaggerViewModelInjector
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
            is StandingsViewModel -> injector.inject(this)
        }
    }
}