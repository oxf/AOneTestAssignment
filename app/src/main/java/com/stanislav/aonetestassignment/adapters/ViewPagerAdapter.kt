package com.stanislav.aonetestassignment.adapters

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import com.stanislav.aonetestassignment.fragments.StandingsFragment

class ViewPagerAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {
    override fun getItem(p0: Int): Fragment {
        val chosen = Feeds.values()[p0]
        return when (chosen) {
            Feeds.ENGLAND -> StandingsFragment.newInstance(chosen.competitionId)
            Feeds.SPAIN -> StandingsFragment.newInstance(chosen.competitionId)
            Feeds.GERMANY -> StandingsFragment.newInstance(chosen.competitionId)
            Feeds.ITALY -> StandingsFragment.newInstance(chosen.competitionId)
            Feeds.FRANCE -> StandingsFragment.newInstance(chosen.competitionId)
        }
    }
    override fun getCount(): Int = Feeds.values().size

    override fun getPageTitle(position: Int): CharSequence? = Feeds.values()[position].name

    enum class Feeds(val competitionId: Long) {
        ENGLAND(2021),
        SPAIN(2014),
        GERMANY(2002),
        ITALY(2019),
        FRANCE(2015)
    }

}