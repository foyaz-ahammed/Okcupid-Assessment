package com.okcupid.assessment.adapters

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.okcupid.assessment.fragments.MatchPercentFragment
import com.okcupid.assessment.fragments.SpecialBlendFragment

/**
 * View pager adapter for the tabs on Main page
 */
class TabsViewpagerAdapter(activity: FragmentActivity): FragmentStateAdapter(activity) {
    override fun getItemCount(): Int = 2

    override fun createFragment(position: Int): Fragment {
        return when(position) {
            0 -> SpecialBlendFragment()
            else -> MatchPercentFragment()
        }
    }
}