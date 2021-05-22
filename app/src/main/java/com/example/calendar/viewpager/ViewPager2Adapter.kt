package com.example.calendar.viewpager

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.calendar.fragment.MonthFragment

class ViewPager2Adapter(fa: FragmentActivity) :
    FragmentStateAdapter(fa) {

    override fun getItemCount(): Int = Int.MAX_VALUE

    override fun createFragment(position: Int): Fragment = MonthFragment()

    companion object {
        const val NUMBER_PAGES = 1000
    }
}