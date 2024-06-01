package com.l0122096.mohammadrizki.demonslayerapp.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.l0122096.mohammadrizki.demonslayerapp.fragments.DemonsFragment
import com.l0122096.mohammadrizki.demonslayerapp.fragments.SlayersFragment

class SectionPagerAdapter(activity: FragmentActivity) : FragmentStateAdapter(activity) {
    override fun getItemCount(): Int {
        return 2
    }

    override fun createFragment(position: Int): Fragment {
        var fragment: Fragment? = null
        when (position) {
            0 -> fragment = SlayersFragment()
            1 -> fragment = DemonsFragment()
        }
        return fragment as Fragment
    }
}