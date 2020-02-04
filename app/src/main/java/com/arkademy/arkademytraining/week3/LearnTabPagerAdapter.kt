package com.arkademy.arkademytraining.week3

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.arkademy.arkademytraining.week2.fragment.AFragment
import com.arkademy.arkademytraining.week2.fragment.BFragment

/**
 * Created by adrianfikri on 2020-02-04.
 */
class LearnTabPagerAdapter(fragmentManager: FragmentManager) : FragmentStatePagerAdapter(fragmentManager) {

    val fragments = arrayOf(AFragment(null), BFragment(null))

    override fun getItem(position: Int): Fragment {
        return fragments[position]
    }

    override fun getCount(): Int = fragments.size

    override fun getPageTitle(position: Int): CharSequence? {
        return when (position) {
            0 -> "Fragment A"
            1 -> "Fragment B"
            else -> ""
        }
    }
}