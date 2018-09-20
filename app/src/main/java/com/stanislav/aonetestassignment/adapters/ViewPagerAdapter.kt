package com.stanislav.aonetestassignment.adapters

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import com.stanislav.aonetestassignment.fragments.NewsFragment

class ViewPagerAdapter(fm: FragmentManager) : FragmentStatePagerAdapter(fm) {
    override fun getItem(p0: Int): Fragment =
    when (Feeds.values()[p0]) {
        Feeds.ENGLAND -> NewsFragment.newInstance("england")
        Feeds.SPAIN -> NewsFragment.newInstance("spain")
        Feeds.GERMANY -> NewsFragment.newInstance("germany")
        Feeds.FRANCE -> NewsFragment.newInstance("france")
    }

    override fun getCount(): Int = Feeds.values().size

    override fun getPageTitle(position: Int): CharSequence? = Feeds.values()[position].name

    enum class Feeds {
        ENGLAND, SPAIN, FRANCE, GERMANY
    }

}