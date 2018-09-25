package com.stanislav.aonetestassignment.adapters

import android.content.Context
import android.content.Intent
import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.stanislav.aonetestassignment.R
import com.stanislav.aonetestassignment.activities.TeamActivity
import com.stanislav.aonetestassignment.databinding.ItemStandingBinding
import com.stanislav.aonetestassignment.models.TeamStanding
import com.stanislav.aonetestassignment.viewholders.StandingItemViewHolder

class StandingsRecyclerViewAdapter(
        private val context: Context
) : RecyclerView.Adapter<StandingItemViewHolder>() {
    private lateinit var standingList: List<TeamStanding>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): StandingItemViewHolder {
        val binding: ItemStandingBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.context), R.layout.item_standing, parent, false)
        return StandingItemViewHolder(binding)
    }

    override fun onBindViewHolder(holder: StandingItemViewHolder, position: Int) {
        holder.bind(standingList[position])
        holder.itemView.setOnClickListener { context.startActivity(Intent(context, TeamActivity::class.java).putExtra("teamId", standingList[position].team.id)) }
    }

    override fun getItemCount(): Int {
        return if (::standingList.isInitialized) standingList.size else 0
    }

    fun updatePostList(postList: List<TeamStanding>) {
        this.standingList = postList
        notifyDataSetChanged()
    }


}