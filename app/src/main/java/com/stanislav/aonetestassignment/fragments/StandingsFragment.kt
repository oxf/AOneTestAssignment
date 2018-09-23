package com.stanislav.aonetestassignment.fragments


import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.stanislav.aonetestassignment.R
import com.stanislav.aonetestassignment.databinding.FragmentStandingsBinding
import com.stanislav.aonetestassignment.viewmodels.StandingsViewModel

class StandingsFragment : Fragment() {

    private lateinit var binding: FragmentStandingsBinding
    private lateinit var viewModel: StandingsViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate<FragmentStandingsBinding>(inflater, R.layout.fragment_standings, container, false)
//       val view = binding.root
//        val vm = binding.viewModel
        // val view = inflater.inflate(R.layout.fragment_standings, container, false)
//        val competitionId = arguments?.get(ARG_AREA) as Long
//        binding = DataBindingUtil.setContentView(this.activity!!.parent, R.layout.fragment_standings)
//        binding.postList.layoutManager = LinearLayoutManager(this.context, LinearLayoutManager.VERTICAL, false)
//
//        viewModel = ViewModelProviders.of(this).get(StandingsViewModel::class.java)
//        binding.viewModel = viewModel
//        return view
        // return null
        return binding.root
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
