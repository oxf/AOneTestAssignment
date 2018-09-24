package com.stanislav.aonetestassignment.adapters

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.stanislav.aonetestassignment.R
import com.stanislav.aonetestassignment.databinding.ItemStandingBinding
import com.stanislav.aonetestassignment.models.TeamStanding
import com.stanislav.aonetestassignment.viewholders.StandingItemViewHolder

class StandingsRecyclerViewAdapter(
        private val onItemClick: ((TeamStanding, StandingItemViewHolder) -> Unit)? = null
) : RecyclerView.Adapter<StandingItemViewHolder>() {
    private lateinit var standingList: List<TeamStanding>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StandingItemViewHolder {
        val binding: ItemStandingBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_standing, parent, false)
        return StandingItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: StandingItemViewHolder, position: Int) {
        holder.bind(standingList[position])
        //holder.itemView.setOnClickListener(onItemClick)
    }

    override fun getItemCount(): Int {
        return if (::standingList.isInitialized) standingList.size else 0
    }

    fun updatePostList(postList: List<TeamStanding>) {
        this.standingList = postList
        notifyDataSetChanged()
    }


}