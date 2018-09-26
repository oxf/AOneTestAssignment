package com.stanislav.aonetestassignment.di

import com.stanislav.aonetestassignment.viewmodels.TeamViewModel
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [(NetworkModule::class)])
interface TeamInjector {
    fun inject(postListViewModel: TeamViewModel)

    @Component.Builder
    interface Builder {
        fun build(): TeamInjector

        fun networkModule(networkModule: NetworkModule): Builder
    }
}