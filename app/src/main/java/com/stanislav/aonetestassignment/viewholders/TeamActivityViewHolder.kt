package com.stanislav.aonetestassignment.viewholders

import android.view.View
import com.bumptech.glide.Glide
import com.stanislav.aonetestassignment.models.TeamFull
import kotlinx.android.synthetic.main.activity_team.view.*

class TeamActivityViewHolder(val view: View) {
    fun bindModel(team: TeamFull) {
        Glide.with(view)
                .load(team.crestUrl)
                .into(view.backdrop)
        view.name.text = "Name : ${team.name}"
        view.tla.text = "Tla : ${team.tla}"
        view.address.text = "Phone : ${team.address}"
        view.phone.text = "Phone : ${team.phone}"
        view.website.text = "Website : ${team.website}"
        view.email.text = "Email : ${team.email}"
        view.founded.text = "Founded : ${team.founded}"
        view.clubColors.text = "Club colors : ${team.clubColors}"
        view.venue.text = "Venuce : ${team.venue}"
    }
}