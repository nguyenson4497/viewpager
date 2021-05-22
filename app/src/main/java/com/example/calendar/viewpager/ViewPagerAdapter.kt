package com.example.calendar.viewpager

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.example.calendar.fragment.MonthFragment
import com.example.calendar.model.DateModel

class ViewPagerAdapter(fm: FragmentManager, behavior: Int, mListDateModel: ArrayList<DateModel>) :
    FragmentStatePagerAdapter(fm, behavior) {

    private var mList: ArrayList<DateModel> = mListDateModel

    override fun getItem(position: Int): Fragment {

        val dateModel: DateModel = mList[position]
        val monthFragment = MonthFragment()
        val bundle = Bundle()
        bundle.putSerializable("date_object", dateModel)
        monthFragment.arguments = bundle

        return monthFragment
    }

    override fun getCount(): Int {
        return Int.MAX_VALUE
    }
}