package com.stanislav.aonetestassignment.viewholders

import android.support.v7.widget.RecyclerView
import com.stanislav.aonetestassignment.databinding.ItemStandingBinding
import com.stanislav.aonetestassignment.models.TeamStanding
import com.stanislav.aonetestassignment.viewmodels.StandingLineViewModel

class StandingItemViewHolder(private val binding: ItemStandingBinding) : RecyclerView.ViewHolder(binding.root) {

    private val viewModel = StandingLineViewModel()

    fun bind(teamStanding: TeamStanding) {
        viewModel.bind(teamStanding)
        binding.viewModel = viewModel
        binding.executePendingBindings()
    }
}