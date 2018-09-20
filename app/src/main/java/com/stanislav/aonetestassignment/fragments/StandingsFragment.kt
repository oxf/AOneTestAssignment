package com.stanislav.aonetestassignment.fragments


import android.app.Application
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.stanislav.aonetestassignment.R
import com.stanislav.aonetestassignment.viewmodels.CompetitionViewModel
import com.stanislav.aonetestassignment.viewmodels.CompetitionViewModelFactory

class StandingsFragment : Fragment() {

    private lateinit var liveData: CompetitionViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_standings, container, false)
        val competitionId = arguments?.get(ARG_AREA) as Long
        liveData = ViewModelProviders.of(this, CompetitionViewModelFactory(Application(), competitionId)).get(CompetitionViewModel::class.java)
        return view
    }

    companion object {
        const val ARG_AREA = "ARG_AREA"

        fun newInstance(competitionId: Long): StandingsFragment = StandingsFragment()
                .also {
                    val b = Bundle()
                    b.putLong(ARG_AREA, competitionId)
                    it.arguments = b
                }
    }
}
