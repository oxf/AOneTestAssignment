package com.stanislav.aonetestassignment.fragments


import android.arch.lifecycle.Observer
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.annotation.StringRes
import android.support.design.widget.Snackbar
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.stanislav.aonetestassignment.R
import com.stanislav.aonetestassignment.databinding.FragmentStandingsBinding
import com.stanislav.aonetestassignment.viewmodels.CompetitionViewModelFactory
import com.stanislav.aonetestassignment.viewmodels.StandingsViewModel

class StandingsFragment : Fragment() {

    private lateinit var binding: FragmentStandingsBinding
    private lateinit var viewModel: StandingsViewModel

    private var errorSnackbar: Snackbar? = null

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        val competitionId = arguments?.get(ARG_AREA) as Long

        binding = DataBindingUtil.inflate<FragmentStandingsBinding>(inflater, R.layout.fragment_standings, container, false)
        binding.postList.layoutManager = LinearLayoutManager(this.context, LinearLayoutManager.VERTICAL, false)
        val factory = CompetitionViewModelFactory(competitionId, this.context!!)

        viewModel = factory.create(StandingsViewModel::class.java)
        viewModel.errorMessage.observe(this, Observer { errorMessage ->
            if (errorMessage != null) showError(errorMessage) else hideError()
        })
        binding.viewModel = viewModel
        return binding.root
    }

    private fun showError(@StringRes errorMessage: Int) {
        errorSnackbar = Snackbar.make(binding.root, errorMessage, Snackbar.LENGTH_INDEFINITE)
        errorSnackbar?.setAction(R.string.retry, viewModel.errorClickListener)
        errorSnackbar?.show()
    }

    private fun hideError() {
        errorSnackbar?.dismiss()
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
